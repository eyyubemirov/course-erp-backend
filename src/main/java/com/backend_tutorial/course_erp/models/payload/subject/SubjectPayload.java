package com.backend_tutorial.course_erp.models.payload.subject;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectPayload {
    String name;

    Long courseId;

    Long languageId;
}