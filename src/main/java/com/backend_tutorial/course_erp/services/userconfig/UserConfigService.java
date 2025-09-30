package com.backend_tutorial.course_erp.services.userconfig;


import com.backend_tutorial.course_erp.models.mybatis.userconfig.UserConfig;

import java.util.List;

public interface UserConfigService {

    void insert(UserConfig userConfig);
    UserConfig findByIdAndUserId(String id, Long userId);

    List<UserConfig> findAll();

    void update(UserConfig userConfig);

    void updateUserLanguage(Long userId, String langId);
}
