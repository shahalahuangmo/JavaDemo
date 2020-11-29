package com.example.demo.system.model.domain.cost;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.CostProjectType;
import com.example.demo.system.model.value.CostStandard;
import com.example.demo.system.model.value.CostUnit;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 收费项目设置
 */
@Data
@Table(name = "costProject")
public class CostProject extends BaseDateEntity {
    /**
     * 收费项目
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
     * 费用
     */
    @Column(name = "price", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    public BigDecimal price;

    /**
     * 收费单位
     */
    @Column(name = "costUnit", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CostUnit costUnit;
}
