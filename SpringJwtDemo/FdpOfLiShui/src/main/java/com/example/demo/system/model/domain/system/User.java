package com.example.demo.system.model.domain.system;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户表
 */
@Data
@Table(name = "user")
public class User extends BaseOrderEntity {
    /**
     * 账号
     */
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 255)
    @IsNotNull
    private String username;
    /**
     * 登录密码
     */
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 255)
    @IsNotNull
    private String password;
    /**
     * 邮件
     */
    @Column(name = "email",type = MySqlTypeConstant.VARCHAR,length = 255)
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
    @Column(name = "token",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String token;
    /**
     * 创建时间
     */
    @Column(name = "createTime",type = MySqlTypeConstant.DATETIME)
    @IsNotNull
    private Date createTime;
    /**
     * 创建时间
     */
    @Column(name = "deleteTime",type = MySqlTypeConstant.DATETIME)
    private Date deleteTime;
    /**
     * 是否删除
     */
    @Column(name = "isDelete",type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean isDelete;
}
