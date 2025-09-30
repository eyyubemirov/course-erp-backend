package com.backend_tutorial.course_erp.exception;

import com.backend_tutorial.course_erp.exception.type.NotFoundExceptionType;
import com.backend_tutorial.course_erp.models.enums.response.ResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static com.backend_tutorial.course_erp.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.backend_tutorial.course_erp.models.enums.response.ErrorResponseMessages.UNEXPECTED;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException {

    ResponseMessages responseMessages;
    NotFoundExceptionType notFoundData;

    // todo:fix. it doesn't return dynamic error message
    @Override
    public String getMessage() {
        return responseMessages.message();

    }
public  static BaseException of(ResponseMessages responseMessages){
    return BaseException.builder()
            .responseMessages(responseMessages)
            .build();

}
    public static BaseException unexpected() {
        return BaseException.of(UNEXPECTED);

    }

    public static BaseException notFound(String target, String field, Object value) {
        return BaseException.builder()
                .responseMessages(NOT_FOUND)
                .notFoundData(
                        NotFoundExceptionType.of(target, Map.of(field, value))
                )
                .build();
    }
}
