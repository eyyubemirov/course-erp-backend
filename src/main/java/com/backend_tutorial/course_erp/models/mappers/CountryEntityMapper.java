package com.backend_tutorial.course_erp.models.mappers;

import com.backend_tutorial.course_erp.models.mybatis.country.Country;
import com.backend_tutorial.course_erp.models.payload.country.CountryPayload;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryEntityMapper {
    CountryEntityMapper INSTANCE = Mappers.getMapper(CountryEntityMapper.class);




    Country toEntity(CountryPayload countryPayload);

}
