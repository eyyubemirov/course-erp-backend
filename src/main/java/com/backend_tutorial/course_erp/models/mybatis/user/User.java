package com.backend_tutorial.course_erp.models.mybatis.user;

import com.backend_tutorial.course_erp.models.enums.user.UserStatus;
import com.backend_tutorial.course_erp.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    String name;
    String surname;
    UserStatus status;
    Long roleId;
    String email;
    String phoneNumber;
    String password;



    public boolean isActive(){
        return UserStatus.ACTIVE.equals(status);
    }


}
