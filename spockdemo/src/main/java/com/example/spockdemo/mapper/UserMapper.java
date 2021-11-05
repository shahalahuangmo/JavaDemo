package com.example.spockdemo.mapper;

import com.example.spockdemo.entity.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:30 下午
 */
@Component
public class UserMapper {
    public UserInfo getById(Integer id){
        return  new UserInfo();
    }
}
