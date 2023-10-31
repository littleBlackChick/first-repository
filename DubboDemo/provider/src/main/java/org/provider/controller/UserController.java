package org.provider.controller;

import org.provider.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/user")
    public String getUser(){

        return userService.getUser();
    }


}
