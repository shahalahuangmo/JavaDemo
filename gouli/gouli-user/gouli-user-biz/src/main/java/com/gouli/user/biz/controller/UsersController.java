package com.gouli.user.biz.controller;



import com.gouli.user.biz.beans.Users;
import com.gouli.user.biz.converter.UserConverter;
import com.gouli.user.biz.dtos.UsersDTO;
import com.gouli.user.biz.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 用户类
 * </p>
 *
 * @author pengnanfa
 * @since 2021-01-14
 */
@Api(tags = {"用户类Controller"})
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UsersService usersService;
    @Value("${server.port}")
    private String port;

    @ApiOperation(value = "返回请求信息", notes = "根据请求参数，返回请求信息")
    @GetMapping("/index")
    public String index(){
        return this.port + " dd44";
    }

    @ApiOperation(value = "获取用户", notes = "根据请求参数，返回请求信息")
    @GetMapping("/getUser")
    public UsersDTO getUser(){
        return userConverter.usersToUsersDTO(usersService.getById(1));
    }

    @ApiOperation(value = "添加用户", notes = "根据请求参数，返回请求信息")
    @GetMapping("/addUser")
    public int addUser(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String code = sb.toString();

        UsersDTO users1 = new UsersDTO("李东"+code,"123456");
        UsersDTO users2 = new UsersDTO("往东"+code,"123456");
        List<UsersDTO> usersDTOList = new ArrayList<>();
        usersDTOList.add(users1);
        usersDTOList.add(users2);
        List<Users> usersList1 = userConverter.UsersDTOToUsersList(usersDTOList);
        return usersService.addAndUpdateUser(usersList1);
    }

    @ApiOperation(value = "测试SpirngBoot事务", notes = "根据请求参数，返回请求信息")
    @GetMapping("/testUser")
    public int testUser(){
        UsersDTO users1 = new UsersDTO("李东","123456");
        UsersDTO users2 = new UsersDTO("往东","123456");
        List<UsersDTO> usersDTOList = new ArrayList<>();
        usersDTOList.add(users1);
        usersDTOList.add(users2);
        List<Users> usersList1 = userConverter.UsersDTOToUsersList(usersDTOList);
        return usersService.testUser(usersList1);
    }

}

