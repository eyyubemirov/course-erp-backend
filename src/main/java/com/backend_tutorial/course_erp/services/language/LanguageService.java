package com.backend_tutorial.course_erp.services.language;


import com.backend_tutorial.course_erp.models.mybatis.language.Language;

import java.util.List;

public interface LanguageService {

    void insert(Language language);
    List<Language> findAll();
    Language findById(Long id);
    void update (Language language,Long id);

    Language getDefaultLanguage();

    List<Language> getAllLanguagesIsLocalize();
}
