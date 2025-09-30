package com.backend_tutorial.course_erp.services.country;


import com.backend_tutorial.course_erp.models.mybatis.country.Country;

import java.util.List;

public interface CountryService {

    void insert(Country country);
    Country findById(long id);

    List<Country> findAll();

    void update(Country country,Long id);
}
