package com.backend_tutorial.course_erp.services.security;

import com.backend_tutorial.course_erp.models.payload.auth.LoginPayload;
import com.backend_tutorial.course_erp.models.payload.auth.RefreshTokenPayload;
import com.backend_tutorial.course_erp.models.payload.auth.SignUpPayload;
import com.backend_tutorial.course_erp.models.payload.otp.BaseOTPChannelRequest;
import com.backend_tutorial.course_erp.models.payload.otp.BaseOTPRequest;
import com.backend_tutorial.course_erp.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload loginPayload);

    LoginResponse refresh(RefreshTokenPayload refreshTokenPayload);

    void logout();

    void signUp(SignUpPayload signUpPayload);

    void signUpOTP(BaseOTPChannelRequest payload);
    void signUpOTPConfirmation(BaseOTPRequest payload);
    void  setAuthentication(String email);


}
