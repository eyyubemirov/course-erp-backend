package com.backend_tutorial.course_erp.services.teacher;


import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.mybatis.teacher.TeachersSchedule;
import com.backend_tutorial.course_erp.repository.TeachersScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeachersScheduleServiceImpl implements TeachersScheduleService {

    private final TeachersScheduleRepository teachersScheduleRepository;


    @Override
    public TeachersSchedule findById(Long id) {
        return teachersScheduleRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(
                        TeachersSchedule.class.getSimpleName(),
                        "id",
                        id
                )
        );
    }

    @Override
    public List<TeachersSchedule> findAll() {
        return teachersScheduleRepository.findAll();
    }

    @Transactional
    @Override
    public void insert(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.insert(teachersSchedule);
    }

    @Transactional
    @Override
    public void update(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.update(teachersSchedule);
    }
}
