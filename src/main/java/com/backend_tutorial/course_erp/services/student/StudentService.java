package com.backend_tutorial.course_erp.services.student;


import com.backend_tutorial.course_erp.models.mybatis.student.Student;

import java.util.List;


public interface StudentService {
    void insert(Student student);

    void update(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void addStudentToGroup(long id, long groupId);
    boolean checkStudentAlreadyAddedToGroup(long id);

}
