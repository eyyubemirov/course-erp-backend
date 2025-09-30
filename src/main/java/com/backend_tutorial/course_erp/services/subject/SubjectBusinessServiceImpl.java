package com.backend_tutorial.course_erp.services.subject;

import com.backend_tutorial.course_erp.models.mappers.SubjectEntityMapper;
import com.backend_tutorial.course_erp.models.payload.subject.SubjectPayload;
import com.backend_tutorial.course_erp.services.language.LanguageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectBusinessServiceImpl implements SubjectBusinessService {
    final SubjectService subjectService;
    final LanguageService languageService;

    @Override
    public void insertSubject(SubjectPayload subjectPayload) {
        languageService.findById(subjectPayload.getLanguageId());
        subjectService.insert(SubjectEntityMapper.INSTANCE.fromSubjectPayload(subjectPayload, 1L));
    }

    @Override
    public void editSubject(long id, SubjectPayload subjectPayload) {
        subjectService.update(SubjectEntityMapper.INSTANCE.toEntity(subjectPayload),id);
    }


}
