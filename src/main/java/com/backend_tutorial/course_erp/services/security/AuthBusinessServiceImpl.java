package com.backend_tutorial.course_erp.services.security;

import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.dto.RefreshTokenDto;
import com.backend_tutorial.course_erp.models.dto.SendOTPDto;
import com.backend_tutorial.course_erp.models.enums.branch.BranchStatus;
import com.backend_tutorial.course_erp.models.mappers.CourseEntityMapper;
import com.backend_tutorial.course_erp.models.mappers.UserEntityMapper;
import com.backend_tutorial.course_erp.models.mybatis.branch.Branch;
import com.backend_tutorial.course_erp.models.mybatis.course.Course;
import com.backend_tutorial.course_erp.models.mybatis.employee.Employee;
import com.backend_tutorial.course_erp.models.mybatis.role.Role;
import com.backend_tutorial.course_erp.models.mybatis.user.User;
import com.backend_tutorial.course_erp.models.payload.auth.LoginPayload;
import com.backend_tutorial.course_erp.models.payload.auth.RefreshTokenPayload;
import com.backend_tutorial.course_erp.models.payload.auth.SignUpPayload;
import com.backend_tutorial.course_erp.models.payload.otp.BaseOTPChannelRequest;
import com.backend_tutorial.course_erp.models.payload.otp.BaseOTPRequest;
import com.backend_tutorial.course_erp.models.response.auth.LoginResponse;
import com.backend_tutorial.course_erp.services.branch.BranchService;
import com.backend_tutorial.course_erp.services.course.CourseService;
import com.backend_tutorial.course_erp.services.employee.EmployeeService;
import com.backend_tutorial.course_erp.services.otp.OTPFactory;
import com.backend_tutorial.course_erp.services.role.RoleService;
import com.backend_tutorial.course_erp.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.backend_tutorial.course_erp.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServiceImpl implements AuthBusinessService {
    private final static String BRANCH_NAME_DEFAULT_PATTERN = "%s Default branch";
    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final CourseService courseService;
    private final BranchService branchService;
    private final EmployeeService employeeService;


    @Override
    public LoginResponse login(LoginPayload payload) {
        authentication(payload);
        return prepareLoginResponse(payload.getEmail(), payload.isRememberMe());


    }

    @Override
    public LoginResponse refresh(RefreshTokenPayload payload) {

        return prepareLoginResponse(
                refreshTokenManager.getEmail(payload.getRefreshToken())
                , payload.isRememberMe());

    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("{} user logout succeed", userDetails.getUsername());
    }

    @Override
    public void signUp(SignUpPayload signUpPayload) {
        if (userService.checkByEmail(signUpPayload.getEmail())) {
            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
        }
        Role defaultRole = roleService.getDefaultRole();

        // Stage 1: User insert
        User user = UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(
                signUpPayload
                , passwordEncoder.encode(signUpPayload.getPassword())
                , defaultRole.getId()
        );
        userService.insert(user);
        // Stage 2: Course insert
        Course course = CourseEntityMapper.INSTANCE.fromSignUpPayload(signUpPayload);

        courseService.insert(course);

        //Stage 3: Default branch insert
        branchService.insert(populateDefaultBranchData(signUpPayload, course));

        //Stage 4: Employee insert
        employeeService.insert(Employee.builder()
                .userId(user.getId())
                .build());
    }

    @Override
    public void signUpOTP(BaseOTPChannelRequest payload) {
        OTPFactory.handle(payload.getChannel()).send(SendOTPDto.of("user1@mail.com","otpsignup-1"));
    }

    @Override
    public void signUpOTPConfirmation(BaseOTPRequest payload) {
             log.info(payload.getOtp()+"confirmed");
    }


    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
        );
    }


    //private util methods
    private void authentication(LoginPayload request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

        } catch (AuthenticationException e) {
            //todo : implement custom exception
            throw e.getCause() instanceof BaseException ?
                    (BaseException) e.getCause() :
                    BaseException.unexpected();
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
        User user = userService.getByEmail(email);
        return LoginResponse.builder()
                .accessToken(accessTokenManager.generator(user))
                .refreshToken(refreshTokenManager.generator(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(rememberMe)
                                .build()
                ))
                .build();

    }

    private Branch populateDefaultBranchData(SignUpPayload payload, Course course) {
        return Branch.builder()
                .name(BRANCH_NAME_DEFAULT_PATTERN.formatted(payload.getCourseName()))
                .status(BranchStatus.ACTIVE)
                .address(payload.getAddress())
                .courseId(course.getId())
                .build();
    }
}
