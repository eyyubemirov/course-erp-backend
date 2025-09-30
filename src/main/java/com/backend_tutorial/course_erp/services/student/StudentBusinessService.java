package com.backend_tutorial.course_erp.services.student;


import com.backend_tutorial.course_erp.models.payload.student.StudentPayload;

public interface StudentBusinessService {

    void addStudent(StudentPayload studentPayload);

    void addStudentToGroup(long studentId, long groupId);
}
