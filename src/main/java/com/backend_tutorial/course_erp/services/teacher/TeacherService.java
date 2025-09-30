package com.backend_tutorial.course_erp.services.teacher;


import com.backend_tutorial.course_erp.models.mybatis.teacher.Teacher;

import java.util.List;

public interface TeacherService {
    void insert(Teacher teacher);

    void update(Teacher teacher);

    Teacher findById(Long id);

    List<Teacher> findAll();
}
