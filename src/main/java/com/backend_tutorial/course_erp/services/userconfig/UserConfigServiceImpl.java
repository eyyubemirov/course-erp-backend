package com.backend_tutorial.course_erp.services.userconfig;



import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.models.mybatis.userconfig.UserConfig;
import com.backend_tutorial.course_erp.repository.UserConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.backend_tutorial.course_erp.constants.UserConfigConstants.DEFAULT_LANGUAGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserConfigServiceImpl implements UserConfigService {


    private final UserConfigRepository userConfigRepository;

    @Override
    public void insert(UserConfig userConfig) {
        userConfigRepository.insert(userConfig);
    }

    @Override
    public UserConfig findByIdAndUserId(String id, Long userId) {
        return userConfigRepository.findByIdAndUserId(id, userId).orElseThrow(
                () -> BaseException.notFound(UserConfig.class.getSimpleName(),"user_config",String.valueOf(id))
        );
    }

    @Override
    public List<UserConfig> findAll() {
        return userConfigRepository.findAll();
    }

    @Override
    public void update(UserConfig userConfig) {
        userConfigRepository.update(userConfig);
    }


    @Override
    public void updateUserLanguage(Long userId, String langId) {

        userConfigRepository.updateConfig(DEFAULT_LANGUAGE, langId, userId);


    }


}
