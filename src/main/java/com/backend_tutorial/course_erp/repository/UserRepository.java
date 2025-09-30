package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper
@Component
public interface UserRepository {

 void insert(User user);
 void update(User user);
 Optional<User> findByEmail(@Param("email") String email);
 Optional<User> findById(@Param("id") Long id);

 Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
