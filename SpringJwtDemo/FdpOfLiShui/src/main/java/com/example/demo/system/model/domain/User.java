package com.example.demo.system.model.domain;

import com.example.demo.system.common.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户表
 */
@Data
public class User extends BaseEntity {
    /**
     * 账号
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 邮件
     */
    private String email;
    /**
     * 手机
     */
    private String phoneNumber;
    /**
     * 序号
     */
    private Integer orderId;
    /**
     * 用户登录token
     */
    private String token;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建时间
     */
    private Date deleteTime;
    /**
     * 是否删除
     */
    private boolean isDelete;
}
