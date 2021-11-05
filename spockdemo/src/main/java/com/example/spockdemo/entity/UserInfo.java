package com.example.spockdemo.entity;

import lombok.Data;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:31 下午
 */
@Data
public class UserInfo {
    public String userName;
    public String address;
    public String city;
    public Integer age;
    public String email;
}
