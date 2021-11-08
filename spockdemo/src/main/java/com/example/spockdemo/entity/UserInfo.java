package com.example.spockdemo.entity;

import lombok.Data;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:31 下午
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String address;
    private String city;
    private Integer age;
    private String email;
}
