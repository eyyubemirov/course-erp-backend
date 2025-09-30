package com.backend_tutorial.course_erp.services.subject;


import com.backend_tutorial.course_erp.models.mybatis.subject.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> findAll();
    Subject findById(Long id);
    void  insert(Subject subject);
    void update (Subject subject,Long id);
}
