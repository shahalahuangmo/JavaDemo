package com.example.demo.system.common;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseOrderEntity extends BaseEntity {
    /**
     * 序号
     */
    @Column(name = "orderId",type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer orderId;
}
