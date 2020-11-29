package com.example.demo.system.model.domain.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 护理计划
 */
@Data
@Table(name = "nursingPlan")
public class NursingPlan extends BaseDateEntity {

    /**
     * 护理开始时间
     */
    @Column(name = "nursingStartTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date nursingStartTime ;

    /**
     * 护理结束时间
     */
    @Column(name = "nursingEndTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date nursingEndTime ;

    /**
     * 护理项目Id
     */
    @Column(name = "nursingItemId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long nursingItemId ;

    /**
     * 护理单元Id
     */
    @Column(name = "nursingUnitIds", type = MySqlTypeConstant.VARCHAR,length = 2000)
    @IsNotNull
    private String nursingUnitIds ;

    /**
     * 标签颜色
     */
    @Column(name = "labelColor", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String labelColor ;

    /**
     * 护理说明
     */
    @Column(name = "nursingRemark", type = MySqlTypeConstant.TEXT)
    private String nursingRemark ;
}
