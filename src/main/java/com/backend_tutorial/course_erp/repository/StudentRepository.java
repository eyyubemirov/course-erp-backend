package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.student.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentRepository {

    void insert(Student student);

    void update(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void addStudentToGroup(@Param("studentId") long studentId, @Param("groupId") long groupId);

    boolean checkStudentAlreadyAddedToGroup(@Param("studentId") long studentId);
}
