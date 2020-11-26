package com.example.demo.system.model.domain;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 系统角色表
 */
@Data
public class Role  extends BaseOrderEntity
{
    /**
     * 角色名称
     */
    @Column(name = "accessName",type = MySqlTypeConstant.VARCHAR,length = 255)
    @IsNotNull
    private String name;
    /**
     * 角色名称
     */
    @Column(name = "accessName",type = MySqlTypeConstant.VARCHAR,length = 255)
    @IsNotNull
    private String roleCode;
    /**
     * 描述
     */
    @Column(name = "accessName",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String displayName;
}
