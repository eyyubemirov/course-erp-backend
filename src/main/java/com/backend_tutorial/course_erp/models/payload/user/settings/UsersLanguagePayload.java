package com.backend_tutorial.course_erp.models.payload.user.settings;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersLanguagePayload {

    String langId;


}
