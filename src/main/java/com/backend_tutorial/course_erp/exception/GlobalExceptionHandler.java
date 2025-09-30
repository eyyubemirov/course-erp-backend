package com.backend_tutorial.course_erp.exception;

import com.backend_tutorial.course_erp.models.base.BaseResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Hidden
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException ex){
   return ResponseEntity.status(ex.getResponseMessages().status()).body(BaseResponse.error(ex));
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleUsernameNotFoundException(UsernameNotFoundException ex){
             BaseException baseException= (BaseException) ex.getCause();
        return ResponseEntity.status(baseException.getResponseMessages().status()).body(BaseResponse.error(baseException));

    }

}
