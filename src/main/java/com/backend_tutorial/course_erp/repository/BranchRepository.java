package com.backend_tutorial.course_erp.repository;

import com.backend_tutorial.course_erp.models.mybatis.branch.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchRepository {
 void insert(Branch branch);
}
