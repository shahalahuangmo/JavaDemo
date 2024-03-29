package com.example.spockdemo.service;

import com.example.spockdemo.entity.UserInfoDTO;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:29 下午
 */
public interface UserService {

    /**
     * 获取用户下信息
     *
     * @param id
     * @return
     */
    UserInfoDTO getUserById(Integer id);

    String getHelloMessage(Integer userId);
}
