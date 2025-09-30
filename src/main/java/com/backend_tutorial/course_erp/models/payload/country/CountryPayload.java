package com.backend_tutorial.course_erp.models.payload.country;

import lombok.AccessLevel;
import lombok.Data;

import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryPayload {
    String name;
}