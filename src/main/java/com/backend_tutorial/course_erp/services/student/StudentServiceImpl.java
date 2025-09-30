package com.backend_tutorial.course_erp.services.student;
import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.mybatis.student.Student;
import com.backend_tutorial.course_erp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void insert(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Student.class.getSimpleName(), "student", String.valueOf(id))
        );
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudentToGroup(long id, long groupId) {
        studentRepository.addStudentToGroup(id, groupId);
    }

    @Override
    public boolean checkStudentAlreadyAddedToGroup(long id) {
        return studentRepository.checkStudentAlreadyAddedToGroup(id);
    }


}
