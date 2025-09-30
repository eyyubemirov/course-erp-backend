package com.backend_tutorial.course_erp.services.appconfig;


import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.mybatis.appconfig.AppConfig;
import com.backend_tutorial.course_erp.repository.AppConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppConfigServiceImpl implements AppConfigService {

    private final AppConfigRepository appConfigRepository;

    @Override
    public List<AppConfig> findAll() {
        return appConfigRepository.findAll();

    }

    @Override
    public AppConfig findById(Long id) {
        return (appConfigRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(AppConfig.class.getSimpleName(), "app_configs", String.valueOf(id))));

    }

    @Override
    public void insert(AppConfig appConfig) {
        appConfigRepository.insert(appConfig);

    }

    @Override
    public void update(AppConfig appConfig) {
        appConfigRepository.update(appConfig);
    }
}
