package com.backend_tutorial.course_erp.models.enums.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorResponseMessages implements ResponseMessages {
    UNEXPECTED("unexpected", "Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("not_found_%s", "%s can't find by %s", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_REGISTERED("email_already_registered", "Email already registered", HttpStatus.CONFLICT),
    FORBIDDEN("forbidden", "Forbidden", HttpStatus.FORBIDDEN),
    USER_NOT_ACTIVE("user_not_active", "User is no active", HttpStatus.FORBIDDEN),
    PHONE_NUMBER_ALREADY_EXIST("phone_number_already_exist", "Phone number already exist", HttpStatus.CONFLICT),
    STUDENT_ALREADY_ADDED_TO_GROUP("student_already_added_to_group", "Student already added to group", HttpStatus.CONFLICT),
    ;


    String key;
    String message;
    HttpStatus status;

    @Override
    public String key() {
        return key;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public HttpStatus status() {
        return status;
    }
}
