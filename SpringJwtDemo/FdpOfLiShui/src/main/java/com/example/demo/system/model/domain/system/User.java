package com.example.demo.system.model.domain.system;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 系统用户表
 */
@Data
@Table(name = "user")
public class User extends FuLLBaseDateEntity {
    /**
     * 账号
     */
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR)
    @IsNotNull
    private String username;
    /**
     * 登录密码
     */
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR)
    @IsNotNull
    private String password;
    /**
     * 邮件
     */
    @Column(name = "email",type = MySqlTypeConstant.VARCHAR)
    @IsNotNull
    private String email;
    /**
     * 手机
     */
    @Column(name = "phoneNumber",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String phoneNumber;
    /**
     * 用户登录token
     */
    @Column(name = "token",type = MySqlTypeConstant.VARCHAR)
    private String token;
}
