package com.example.demo.system.common;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseDateEntity extends BaseEntity {
    /**
     * 创建时间
     */
    @Column(name = "createTime",type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date createTime;
}
