package com.backend_tutorial.course_erp.models.mappers;

import com.backend_tutorial.course_erp.models.mybatis.user.User;
import com.backend_tutorial.course_erp.models.payload.auth.SignUpPayload;
import com.backend_tutorial.course_erp.models.payload.student.StudentPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status",constant = "ACTIVE")
    @Mapping(target = "roleId",source = "roleId")
    User fromSignUpPayloadToUser(SignUpPayload signUpPayload, String encryptedPassword,Long roleId);


    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "roleId", source = "roleId")
    User fromStudentPayloadToUser(StudentPayload studentPayload, String encryptedPassword, Long roleId);
}
