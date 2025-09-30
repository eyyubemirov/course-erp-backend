package com.backend_tutorial.course_erp.controller;

import com.backend_tutorial.course_erp.models.base.BaseResponse;
import com.backend_tutorial.course_erp.models.payload.auth.LoginPayload;
import com.backend_tutorial.course_erp.models.payload.auth.RefreshTokenPayload;
import com.backend_tutorial.course_erp.models.payload.auth.SignUpPayload;
import com.backend_tutorial.course_erp.models.payload.otp.BaseOTPChannelRequest;
import com.backend_tutorial.course_erp.models.payload.otp.BaseOTPRequest;
import com.backend_tutorial.course_erp.models.response.auth.LoginResponse;
import com.backend_tutorial.course_erp.services.security.AuthBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {

        return BaseResponse.success(authBusinessService.login(payload));

    }
    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refresh(@RequestBody RefreshTokenPayload refreshTokenPayload){
         return BaseResponse.success(authBusinessService.refresh(refreshTokenPayload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout(){
        authBusinessService.logout();
        return BaseResponse.success();
    }

    @PostMapping("/sign-up")
    public BaseResponse<Void> signup(@RequestBody SignUpPayload payload){
//        System.out.println(UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(signUpPayload,"123123",1L));
      authBusinessService.signUp(payload);
        return BaseResponse.success();
    }

    @PostMapping("/sign-up/otp/request")
    public  BaseResponse<Void>otpRequest(@RequestBody BaseOTPChannelRequest payload){
     authBusinessService.signUpOTP(payload);
     return BaseResponse.success();
    }
    @PostMapping("/sign-up/otp/confirmation")
    public  BaseResponse<Void>otpConfirmation(@RequestBody BaseOTPRequest payload){
        authBusinessService.signUpOTPConfirmation(payload);
        return BaseResponse.success();
    }
}
