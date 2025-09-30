package com.backend_tutorial.course_erp.services.subject;


import com.backend_tutorial.course_erp.models.payload.subject.SubjectPayload;

public interface SubjectBusinessService {
    void insertSubject(SubjectPayload subjectPayload);

    void editSubject(long id,SubjectPayload subjectPayload);
}
