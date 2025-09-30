package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.appconfig.AppConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AppConfigRepository {
    void insert(AppConfig appConfig);

    Optional<AppConfig> findById(@Param("id") long id);

    List<AppConfig> findAll();

    void update(AppConfig appConfig);
}
