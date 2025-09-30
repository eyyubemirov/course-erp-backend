package com.backend_tutorial.course_erp.services.branch;

import com.backend_tutorial.course_erp.models.mybatis.branch.Branch;
import com.backend_tutorial.course_erp.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchServiceImpl implements  BranchService{
    private final BranchRepository branchRepository;
    @Override
    public void insert(Branch branch) {
        branchRepository.insert(branch);
    }
}
