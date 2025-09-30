package com.backend_tutorial.course_erp.models.mybatis.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class isDeletedEntity {
boolean isDeleted;
}
