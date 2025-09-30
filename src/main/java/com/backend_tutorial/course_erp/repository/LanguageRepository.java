package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.language.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;


@Mapper
public interface LanguageRepository {
    void insert(Language language);
    List<Language> findAll();
    Optional<Language> findById(@Param("id") Long id);
    void update(Language language,Long id);

    Optional<Language> getDefaultLanguage();

    List<Language> getAllLanguagesIsLocalize();
}
