package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.role.Role;
import com.backend_tutorial.course_erp.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper
@Component
public interface RoleRepository {


 Optional<Role> findByName(@Param("name") String name);
}
