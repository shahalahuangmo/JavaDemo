package com.example.demo.common.dto.input;

import lombok.Data;

@Data
public class UserInfo {
    /**
     * 账号
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 修改密码
     */
    private String newPassWord;
    /**
     * 邮件
     */
    private String email;
    /**
     * 手机
     */
    private String phoneNumber;
    /**
     * 用户登录token
     */
    private String token;
}
