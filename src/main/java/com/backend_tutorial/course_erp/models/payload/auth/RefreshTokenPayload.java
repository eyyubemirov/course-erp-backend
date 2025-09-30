package com.backend_tutorial.course_erp.models.payload.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenPayload {
    String refreshToken;
    boolean rememberMe;
}
