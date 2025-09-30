package com.backend_tutorial.course_erp.models.mybatis.userconfig;


import com.backend_tutorial.course_erp.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserConfig extends BaseEntity<String> {
    String value;
    Long userId;
}


