package com.backend_tutorial.course_erp.services.teacher;


import com.backend_tutorial.course_erp.models.mybatis.teacher.TeachersSchedule;

import java.util.List;

public interface TeachersScheduleService {
    void insert(TeachersSchedule teachersSchedule);

    TeachersSchedule findById(Long id);

    List<TeachersSchedule> findAll();

    void update(TeachersSchedule teachersSchedule);
}
