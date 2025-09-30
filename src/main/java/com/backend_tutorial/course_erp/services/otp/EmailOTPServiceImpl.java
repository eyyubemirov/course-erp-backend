package com.backend_tutorial.course_erp.services.otp;

import com.backend_tutorial.course_erp.models.dto.SendOTPDto;
import com.backend_tutorial.course_erp.services.redis.RedisService;
import com.backend_tutorial.course_erp.utils.OTPUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailOTPServiceImpl implements OTPService {
    private final RedisService redisService;
    @Override
    public void send(SendOTPDto dto) {
        final String otp= OTPUtils.generate();

        redisService.set(dto.getKey(),otp,5);

        log.info("OTP send via Email to: {}, OTP: {}",dto.getTarget(),otp);
    }
}
