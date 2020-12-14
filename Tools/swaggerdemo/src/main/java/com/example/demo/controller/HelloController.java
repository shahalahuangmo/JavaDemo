package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台Controller
 */
@Api(tags = "Hello控制类")
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("hello控制类")
    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setPassword("123465");
        user.setUsername("test");
        return  user;
    }
}
