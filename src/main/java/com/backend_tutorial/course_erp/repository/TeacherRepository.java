package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.teacher.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeacherRepository {
    void insert(Teacher teacher);

    void update(Teacher teacher);

    Optional<Teacher> findById(Long id);

    List<Teacher> findAll();
}
