package com.gouli.user.biz.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.gouli.common.core.auth.UserInfo;
import com.gouli.common.dto.input.user.UserLoginDTO;
import com.gouli.common.dto.output.user.UsersDTO;
import com.gouli.common.redis.util.RedisUtils;
import com.gouli.common.core.auth.annotion.CurrentUser;
import com.gouli.user.biz.converter.UserConverter;
import com.gouli.user.biz.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
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
@Api(tags = {"测试Controller"})
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UsersService usersService;
    @Value("${server.port}")
    private String port;

    @ApiOperation(value = "返回请求信息", notes = "根据请求参数，返回请求信息")
    @GetMapping("/index")
    public String index(@CurrentUser UserInfo userInfo){
        return this.port + " dd44" + userInfo.getUsername();
    }

    @ApiOperation(value = "获取用户", notes = "根据请求参数，返回请求信息")
    @GetMapping("/getUser")
    public UsersDTO getUser(){
        String key  = (new Date()).toString();
        redisUtils.setString(key,port, 50L);
        return userConverter.usersToUsersDTO(usersService.getById(1));
    }

    @ApiOperation(value = "添加用户", notes = "根据请求参数，返回请求信息")
    @PostMapping("/addUser")
    public int addUser(@Valid @RequestBody UserLoginDTO userLoginDTO){
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
        return usersService.addAndUpdateUser(usersDTOList);
    }

    @ApiOperation(value = "添加用户", notes = "根据请求参数，返回请求信息")
    @PostMapping("/addUserFrom")
    public int addUserFrom(@Validated @RequestBody UserLoginDTO userLoginDTO){
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
        return usersService.addAndUpdateUser(usersDTOList);
    }

    @ApiOperation(value = "测试SpirngBoot事务", notes = "根据请求参数，返回请求信息")
    @GetMapping("/testUser")
    public int testUser(){
        UsersDTO users1 = new UsersDTO("李东","123456");
        UsersDTO users2 = new UsersDTO("往东","123456");
        List<UsersDTO> usersDTOList = new ArrayList<>();
        usersDTOList.add(users1);
        usersDTOList.add(users2);
        return usersService.testUser(usersDTOList);
    }

    @ApiOperation(value = "测试Mybatis分页插件", notes = "根据请求参数，返回请求信息")
    @GetMapping("/pageUser")
    public PageInfo<UsersDTO> pagedUser(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("userName") String userName){
        PageInfo<UsersDTO> pageInfoList = usersService.selectPageInfo(pageNum,pageSize,userName);
        return pageInfoList;
    }

    @ApiOperation(value = "测试MybatisPlus分页插件", notes = "根据请求参数，返回请求信息")
    @GetMapping("/pagedMybatisPlusUser")
    public IPage<UsersDTO> pagedMybatisPlusUser(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("userName") String userName){

        return usersService.selectPageVo(pageNum,pageSize,userName);
    }
}

