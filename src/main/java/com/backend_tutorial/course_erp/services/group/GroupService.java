package com.backend_tutorial.course_erp.services.group;


import com.backend_tutorial.course_erp.models.mybatis.group.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();
    Group findById(Long id);
    void insert(Group group);
    void  update(Group group,Long id);
}
