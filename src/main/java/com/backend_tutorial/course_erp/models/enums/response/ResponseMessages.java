package com.backend_tutorial.course_erp.models.enums.response;

import org.springframework.http.HttpStatus;

public interface ResponseMessages {

    String key();

    String message();

    HttpStatus status();
}
