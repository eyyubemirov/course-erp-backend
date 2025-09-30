package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.employee.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    void  insert(Employee employee);
}
