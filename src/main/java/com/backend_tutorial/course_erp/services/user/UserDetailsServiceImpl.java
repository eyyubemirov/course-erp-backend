package com.backend_tutorial.course_erp.services.user;

import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.enums.response.ErrorResponseMessages;
import com.backend_tutorial.course_erp.models.mybatis.user.User;
import com.backend_tutorial.course_erp.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.backend_tutorial.course_erp.models.enums.response.ErrorResponseMessages.USER_NOT_ACTIVE;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    //todo: currently our system supports only email login, but in the futur
    //  we have implement phone number version    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userService.getByEmail(username);
        if (!user.isActive()){
            throw new UsernameNotFoundException(
                    USER_NOT_ACTIVE.message(),
                    BaseException.of(USER_NOT_ACTIVE)
            );
        }

        return new LoggedInUserDetails(
                user.getEmail(),user.getPassword(),new ArrayList<>()
        );
    }
}
