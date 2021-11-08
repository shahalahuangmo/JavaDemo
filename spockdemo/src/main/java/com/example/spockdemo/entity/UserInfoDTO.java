package com.example.spockdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:34 下午
 */
@Data
public class UserInfoDTO {
    private Integer id;
    private String userName;
    private String address;
    private String city;
    private Integer age;
    private String email;
    private String postCode;
    private List<Order> userOrders;
}
