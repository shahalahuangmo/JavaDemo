package com.example.demo.system.model.entity.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 护工工作安排(护工与床位对应关系)
 */
@Data
@Table(name = "nursingPersonSetting")
public class NursingPersonSetting extends BaseDateEntity {

    /**
     * 护工ID
     */
    @Column(name = "nursingPersonId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long nursingPersonId ;

    /**
     * 床位Id
     */
    @Column(name = "bedId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long bedId ;

    /**
     * 护理日期
     */
    @Column(name = "bedName", type = MySqlTypeConstant.VARCHAR,length = 200)
    @IsNotNull
    private String bedName ;
}
