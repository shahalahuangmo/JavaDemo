package com.example.demo.system.model.entity.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 护工工作计划
 */
@Data
@Table(name = "nursingPersonPlan")
public class NursingPersonPlan extends BaseDateEntity {

    /**
     * 护理班次ID
     */
    @Column(name = "timeSchedulingId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long timeSchedulingId ;

    /**
     * 护工组ID
     */
    @Column(name = "groupId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long groupId ;

    /**
     * 护理日期
     */
    @Column(name = "nursingTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date nursingTime ;
}
