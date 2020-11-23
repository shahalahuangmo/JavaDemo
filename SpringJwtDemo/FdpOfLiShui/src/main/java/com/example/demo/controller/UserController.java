package com.example.demo.controller;


import com.example.demo.common.dto.input.UserInfo;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userIService;

    /**
     * 用户注册添加
     * @param userInfo
     * @return
     */
    @PostMapping("/addUser")
    public int addUser(@RequestBody UserInfo userInfo){
        return userIService.insertUser(userInfo);
    }

    /**
     * 更新用户密码
     * @param userInfo
     * @return
     */
    @PostMapping("/updateUserPassWord")
    public int updateUserPassWord(@RequestBody UserInfo userInfo){
        return userIService.updateUserPassWord(userInfo);
    }

}
