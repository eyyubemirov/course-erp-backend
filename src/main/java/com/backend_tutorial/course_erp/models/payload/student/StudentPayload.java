package com.backend_tutorial.course_erp.models.payload.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentPayload {

    //todo: validation
    String name;
    String surname;
    String email;
    String phoneNumber;

}