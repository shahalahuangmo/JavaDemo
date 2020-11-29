package com.example.demo.system.model.domain.cost;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.RechargeType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 充值记录
 */
@Data
@Table(name = "rechargeRecord")
public class RechargeRecord extends FuLLBaseDateEntity {
    /**
     * 入托登记ID
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Long entrepreneurId;

    /**
     * 充值类型
     */
    @Column(name = "rechargeType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private RechargeType rechargeType;

    /**
     * 小计
     */
    @Column(name = "amount", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    private BigDecimal amount;
}
