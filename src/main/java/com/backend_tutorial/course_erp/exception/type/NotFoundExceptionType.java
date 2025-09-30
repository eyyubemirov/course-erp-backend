package com.backend_tutorial.course_erp.exception.type;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PROTECTED)
public class NotFoundExceptionType {

    String target;
    Map<String, Object> fields;

    public static NotFoundExceptionType of(String target, Map<String, Object> fields) {
        return NotFoundExceptionType.builder()
                .target(target)
                .fields(fields)
                .build();
    }
}
