package com.backend_tutorial.course_erp.models.mybatis.language;

import com.backend_tutorial.course_erp.models.mybatis.base.BaseEntity;import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Language extends BaseEntity<Long> {

    String name;
    String icon;
    Boolean hasLocalization;
    Boolean isDefault;
}
