package com.example.demo.system.model.domain.system;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 访问路径
 */
@Data
@Table(name = "accessPath")
public class AccessPath  extends BaseOrderEntity {
    /**
     * 访问名称
     */
    @Column(name = "accessName",type = MySqlTypeConstant.VARCHAR,length = 500)
    @IsNotNull
    private String accessName;

    /**
     * 访问路径
     */
    @Column(name = "accessPath",type = MySqlTypeConstant.VARCHAR,length = 2000)
    @IsNotNull
    private String accessPath;

    /**
     * 描述
     */
    @Column(name = "displayName",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String displayName;

}
