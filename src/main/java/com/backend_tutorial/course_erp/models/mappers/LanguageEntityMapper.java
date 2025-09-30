package com.backend_tutorial.course_erp.models.mappers;

import com.backend_tutorial.course_erp.models.mybatis.language.Language;
import com.backend_tutorial.course_erp.models.payload.language.LanguagePayLoad;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageEntityMapper {

    LanguageEntityMapper INSTANCE = Mappers.getMapper(LanguageEntityMapper.class);

    Language toEntity(LanguagePayLoad languagePayLoad);

}
