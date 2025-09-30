package com.backend_tutorial.course_erp.models.mybatis.branch;

import com.backend_tutorial.course_erp.models.enums.branch.BranchStatus;
import com.backend_tutorial.course_erp.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch extends BaseEntity {

    String name;
    BranchStatus status;
    String address;
    Double lat;
    Double lon;
    Long courseId;
}
