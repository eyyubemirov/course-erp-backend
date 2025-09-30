package com.backend_tutorial.course_erp.models.payload.otp;

import com.backend_tutorial.course_erp.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseOTPChannelRequest {


    private OTPChannel channel;
}
