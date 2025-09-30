package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.course.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository {

    void  insert(Course course);
}
