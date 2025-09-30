package com.backend_tutorial.course_erp.models.mappers;

import com.backend_tutorial.course_erp.models.mybatis.group.Group;
import com.backend_tutorial.course_erp.models.payload.group.GroupPayload;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupEntityMapper {

    GroupEntityMapper INSTANCE = Mappers.getMapper(GroupEntityMapper.class);

    Group toEntity (GroupPayload groupPayload);



}
