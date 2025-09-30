package com.backend_tutorial.course_erp.models.mappers;


import com.backend_tutorial.course_erp.models.mybatis.subject.Subject;
import com.backend_tutorial.course_erp.models.payload.subject.SubjectPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectEntityMapper {
    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);

    @Mapping(target = "courseId", source = "courseId")
    Subject fromSubjectPayload(SubjectPayload subjectRequestDto, Long courseId);


    Subject toEntity (SubjectPayload subjectPayload);
}
