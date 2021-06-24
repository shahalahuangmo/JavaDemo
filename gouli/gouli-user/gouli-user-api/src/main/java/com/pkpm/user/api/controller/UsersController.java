package com.pkpm.user.api.controller;

import com.gouli.common.core.responseresult.ResponseData;
import com.gouli.common.dto.output.user.UsersDTO;
import com.pkpm.user.api.feign.UsersFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@RestController
@RequestMapping("/feign")
public class UsersController {
    @Autowired
    private UsersFeign usersFeign;

    @GetMapping("/index")
    public ResponseData<String> index(){
        return usersFeign.index();
    }

    @GetMapping("/getUser")
    public ResponseData<UsersDTO> getUser(){
        return usersFeign.getUser();
    }

    @GetMapping("/addUser")
    public ResponseData<Integer> addUser(){
        return usersFeign.addUser();
    }

    @GetMapping("/testUser")
    public ResponseData<Integer> testUser(){
        return usersFeign.testUser();
    }
}
