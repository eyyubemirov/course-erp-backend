package com.backend_tutorial.course_erp.models.dto;

import com.backend_tutorial.course_erp.models.mybatis.user.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenDto {

    boolean rememberMe;

    User  user;
}
