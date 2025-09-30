package com.backend_tutorial.course_erp.models.mybatis.course;

import com.backend_tutorial.course_erp.models.enums.course.CourseStatus;
import com.backend_tutorial.course_erp.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {


    String name;

    CourseStatus status;
}
