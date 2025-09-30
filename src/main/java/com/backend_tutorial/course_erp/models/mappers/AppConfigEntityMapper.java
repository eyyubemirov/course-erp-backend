package com.backend_tutorial.course_erp.models.mappers;
import com.backend_tutorial.course_erp.models.mybatis.appconfig.AppConfig;
import com.backend_tutorial.course_erp.models.response.appconfig.AppConfigResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AppConfigEntityMapper {

    AppConfigEntityMapper INSTANCE = Mappers.getMapper(AppConfigEntityMapper.class);

    AppConfigResponse fromEntityToPayload (AppConfig appConfig);

    List<AppConfigResponse> fromEntityToPayload (List<AppConfig> appConfigs);

}
