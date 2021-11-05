package com.example.spockdemo.service.impl;

import com.example.spockdemo.entity.UserInfo;
import com.example.spockdemo.entity.UserInfoDTO;
import com.example.spockdemo.mapper.UserMapper;
import com.example.spockdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:29 下午
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfoDTO getUserById(Integer id) {
        UserInfo userInfo = userMapper.getById(id);
        UserInfoDTO dto = new UserInfoDTO();
        if (null == userInfo) {
            return dto;
        }
        BeanUtils.copyProperties(userInfo, dto);
        if ("上海市".equals(dto.getCity())) {
            dto.setPostCode("200000");
        }
        if ("北京市".equals(dto.getCity())) {
            dto.setPostCode("100000");
        }
        return dto;
    }
}
