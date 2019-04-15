package com.controller;

import com.entity.UserEntity;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserControll {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(UserEntity user) {

        boolean result = userService.login(user);
        if(result == true) {
            return "/success.html";
        }else {
            return "/failure.html";
        }
    }
}
