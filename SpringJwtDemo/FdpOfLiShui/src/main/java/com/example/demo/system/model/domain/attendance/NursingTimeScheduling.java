package com.example.demo.system.model.domain.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 护理时间安排
 */
@Data
@Table(name = "nursingTimeScheduling")
public class NursingTimeScheduling extends BaseDateEntity {
    /**
     * 标签颜色
     */
    @Column(name = "labelColor", type = MySqlTypeConstant.VARCHAR,length = 150)
    @IsNotNull
    private String labelColor ;

    /**
     * 班次名称
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR,length = 250)
    @IsNotNull
    private String name ;

    /**
     *  简化名称
     */
    @Column(name = "shortName", type = MySqlTypeConstant.VARCHAR,length = 150)
    @IsNotNull
    private String shortName ;

    /**
     * 排班开始时间
     */
    @Column(name = "startTime", type = MySqlTypeConstant.TIMESTAMP)
    @IsNotNull
    private Timestamp startTime;

    /**
     * 班次结束时间
     */
    @Column(name = "endTime", type = MySqlTypeConstant.TIMESTAMP)
    @IsNotNull
    private Timestamp endTime;

    /**
     * 工时(单位小时)
     */
    @Column(name = "hour", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    private BigDecimal hour;
}
