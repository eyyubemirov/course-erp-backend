package com.backend_tutorial.course_erp.services.user;

import com.backend_tutorial.course_erp.models.mybatis.user.User;

public interface UserService {
     void insert(User user);
    void update(User user);
    User getById(Long id);
    boolean checkByEmail(String email);
    User getByEmail(String email);
    boolean checkByPhoneNumber(String phoneNumber);

}
