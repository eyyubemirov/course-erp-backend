package com.backend_tutorial.course_erp.services.course;

import com.backend_tutorial.course_erp.models.mybatis.course.Course;
import com.backend_tutorial.course_erp.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public void insert(Course course) {
        courseRepository.insert(course);

    }
}
