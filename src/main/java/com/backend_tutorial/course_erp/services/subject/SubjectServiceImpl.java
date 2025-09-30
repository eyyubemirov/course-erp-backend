package com.backend_tutorial.course_erp.services.subject;


import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.mybatis.subject.Subject;
import com.backend_tutorial.course_erp.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(
                ()-> BaseException.notFound(Subject.class.getSimpleName(),"subject",String.valueOf(id)));
    }

    @Override
    public void insert(Subject subject) {
        subjectRepository.insert(subject);
    }

    @Override
    public void update(Subject subject, Long id) {
        subjectRepository.update(subject, id);
    }
}


