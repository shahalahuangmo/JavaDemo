package com.example.demo.system.common;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class FuLLBaseDateEntity extends BaseDateEntity {
    /**
     * 删除时间
     */
    @Column(name = "deleteTime",type = MySqlTypeConstant.DATE)
    private Date deleteTime;

    /**
     * 创建人
     */
    @Column(name = "creator",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long creator;

    /**
     * 删除人
     */
    @Column(name = "deleter",type = MySqlTypeConstant.BIGINT)
    private Long deleter;

    /**
     * 是否删除
     */
    @Column(name = "isDelete",type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean isDelete;
}
