package com.backend_tutorial.course_erp.controller;


import com.backend_tutorial.course_erp.models.base.BaseResponse;
import com.backend_tutorial.course_erp.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private UserService userService;
    @GetMapping("/test")
    public BaseResponse<String> test() {
        UserDetails userDetails=(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         return BaseResponse.success(userDetails.getUsername());
    }


    @GetMapping("/test/no-auth")
    public BaseResponse<String> testNoAuth() {
//        userService.getByEmail("ssadfsdfsdfsd");

        return BaseResponse.success("CourseStatus-Erp No Auth");
    }
}
