package com.example.spockdemo.controller;

import com.example.spockdemo.entity.UserInfoDTO;
import com.example.spockdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-09 22:54
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUserById/{userId}")
    public UserInfoDTO getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }


}
