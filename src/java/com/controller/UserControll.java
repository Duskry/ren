package com.controller;

import com.entity.UserEntity;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserControll {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(UserEntity user) {
        System.out.println("it has come in");
        boolean result = userService.login(user);
        if(result == true) {
            System.out.println("OK");
            return "/success.html";
        }else {
            System.out.println("NO");
            return "/failure.html";
        }

    }
    @RequestMapping("/yes")
    public static void ss(){
        System.out.println("yes");
    }
}
