package com.backend_tutorial.course_erp.services.appconfig;


import com.backend_tutorial.course_erp.models.mybatis.appconfig.AppConfig;

import java.util.List;

public interface AppConfigService {

    List<AppConfig> findAll();

    AppConfig findById(Long id);

    void insert(AppConfig appConfig);

    void update(AppConfig appConfig);
}
