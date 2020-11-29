package com.example.demo.system.model.entity.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 护理项目
 */
@Data
@Table(name = "handoverInfo")
public class HandoverInfo extends BaseDateEntity {
    /**
     * 交接项目
     */
    @Column(name = "handOverProject", type = MySqlTypeConstant.BIGINT)
    private Long handOverProject ;

    /**
     * 护理班次ID
     */
    @Column(name = "timeSchedulingId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long timeSchedulingId ;

    /**
     *  入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId ;

    /**
     *  护理班次开始时间
     */
    @Column(name = "startTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date startTime ;

    /**
     *  护理班次结束时间
     */
    @Column(name = "endTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date endTime ;

    /**
     * 自定义项目
     */
    @Column(name = "handOverProjectRemark", type = MySqlTypeConstant.TEXT)
    private String handOverProjectRemark ;
}
