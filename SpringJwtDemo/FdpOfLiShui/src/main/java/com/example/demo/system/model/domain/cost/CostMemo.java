package com.example.demo.system.model.domain.cost;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.CostItemType;
import com.example.demo.system.model.value.CostStandard;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 费用备忘录
 */
@Data
@Table(name = "costMemo")
public class CostMemo extends BaseDateEntity {
    /**
     * 收费标准
     */
    @Column(name = "costStandard", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CostStandard costStandard;
    /**
     * 小计
     */
    @Column(name = "amount", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    private BigDecimal amount;
    /**
     * 残疾证号码
     */
    @Column(name = "disabledCardNumber", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String disabledCardNumber;
    /**
     * 是否可删除
     */
    @Column(name = "canOperate", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean canOperate;
    /**
     * 项目类型
     */
    @Column(name = "costItemType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CostItemType costItemType;
}
