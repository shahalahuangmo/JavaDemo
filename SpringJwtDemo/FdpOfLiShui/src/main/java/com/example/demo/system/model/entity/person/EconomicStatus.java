package com.example.demo.system.model.entity.person;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.AveragePersonalIncome;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 经济状况
 */
@Data
@Table(name = "economicStatus")
public class EconomicStatus extends BaseOrderEntity {
    /**
     * 个人信息Id
     */
    @Column(name = "personId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long  personId ;

    /**
     * 收入来源
     */
    @Column(name = "sourceIncome", type = MySqlTypeConstant.VARCHAR,length = 200)
    private String sourceIncome ;

    /**
     * 个人平均收入
     */
    @Column(name = "averagePersonalIncome", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AveragePersonalIncome averagePersonalIncome ;

    /**
     * 其他收入来源说明
     */
    @Column(name = "otherInstructions", type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String otherInstructions ;
}
