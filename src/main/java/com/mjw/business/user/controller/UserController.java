package com.mjw.business.user.controller;

import com.mjw.business.user.model.User;
import com.mjw.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author MinJunWen
 * @Data 2018/11/23 17:46
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public User findUserById(int id){
        return userService.findUserById(id);
    }

}
