package com.example.spockdemo.service;

import com.example.spockdemo.entity.UserInfoDTO;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:29 下午
 */
public interface UserService {
    UserInfoDTO getUserById(Integer id);
}
