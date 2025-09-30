package com.backend_tutorial.course_erp.models.base;

import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.exception.type.NotFoundExceptionType;
import com.backend_tutorial.course_erp.models.enums.response.ResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import static com.backend_tutorial.course_erp.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.backend_tutorial.course_erp.models.enums.response.SuccessResponseMessages.SUCCESS;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder (access = AccessLevel.PRIVATE)
public class BaseResponse<T> {
    private HttpStatus status;
    Meta meta;
//    private T data;

    @Data
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static final class Meta {
        String key;
        String message;


        public static Meta of(String key, String message) {
            return Meta.builder()
                    .key(key)
                    .message(message)
                    .build();

        }

        public static Meta of(ResponseMessages responseMessages) {

            return of(responseMessages.key(), responseMessages.message());
        }
        public static Meta of(BaseException ex) {

            if (ex.getResponseMessages().equals(NOT_FOUND)){
                NotFoundExceptionType notfoundData=ex.getNotFoundData();

                 return of(String.format(ex.getResponseMessages().key(),notfoundData.getTarget().toLowerCase() ),
                         String.format(ex.getResponseMessages().message(),notfoundData.getTarget().toLowerCase() ,notfoundData.getFields().toString())

                 );


            };
            return of(ex.getResponseMessages());
        }

    }

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.OK)
//                .data(data)
                .meta(Meta.of(SUCCESS))
                .build();
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    public static BaseResponse<?> error(BaseException ex) {
        return BaseResponse.builder()
                .meta(Meta.of(ex))
                .status(ex.getResponseMessages().status())
                .build();
    }
}
