package com.backend_tutorial.course_erp.services.otp;

import com.backend_tutorial.course_erp.models.dto.SendOTPDto;

//Factory Pattern
public interface OTPService {

       void   send(SendOTPDto dto);

}
