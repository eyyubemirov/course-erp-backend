package com.backend_tutorial.course_erp.services.otp;

import com.backend_tutorial.course_erp.models.enums.otp.OTPChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OTPFactory {
    private static EmailOTPServiceImpl emailChannel;
    private static SMSOTPServiceImpl smsChannel;

    public OTPFactory(EmailOTPServiceImpl emailChannel,
                      SMSOTPServiceImpl smsChannel) {
          OTPFactory.emailChannel=emailChannel;
          OTPFactory.smsChannel=smsChannel;

    }

    public static OTPService handle(OTPChannel channel){
        return switch (channel){
            case SMS -> smsChannel;
            case EMAIL -> emailChannel;
        };
    }
}
