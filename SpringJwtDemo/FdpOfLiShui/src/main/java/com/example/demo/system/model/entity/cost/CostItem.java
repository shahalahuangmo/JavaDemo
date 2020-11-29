package com.example.demo.system.model.entity.cost;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.CostItemType;
import com.example.demo.system.model.value.CostProjectType;
import com.example.demo.system.model.value.CostStandard;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 费用项目
 */
@Data
@Table(name = "costItem")
public class CostItem extends BaseDateEntity {

    /**
     * 结算单ID
     */
    @Column(name = "costBillId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long costBillId;
    /**
     * 是否固定清单项
     */
    @Column(name = "isFixed", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean isFixed;
    /**
     * 项目类型
     */
    @Column(name = "costProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CostProjectType costProjectType;
    /**
     * 收费标准
     */
    @Column(name = "costStandard", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CostStandard costStandard;
    /**
     * 单价
     */
    @Column(name = "price", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    private BigDecimal price;
    /**
     * 数量
     */
    @Column(name = "size", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer size;
    /**
     * 小计
     */
    @Column(name = "amount", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    private BigDecimal amount;
    /**
     * 项目类型
     */
    @Column(name = "costItemType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CostItemType costItemType;
    /**
     * 是否是两项补贴
     */
    @Column(name = "isTwoSubsidy", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean isTwoSubsidy;

}
