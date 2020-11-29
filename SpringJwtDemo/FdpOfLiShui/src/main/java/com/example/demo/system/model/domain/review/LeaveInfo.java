package com.example.demo.system.model.domain.review;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.example.demo.system.model.value.AuditResult;
import com.example.demo.system.model.value.CheckInStatus;
import com.example.demo.system.model.value.LeaveInfoType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 请假
 */
@Data
@Table(name = "leaveInfo")
public class LeaveInfo extends FuLLBaseDateEntity {

    /**
     * 审核项目类型
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType;


    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;

    /**
     * 请假类型
     */
    @Column(name = "leaveInfoType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private LeaveInfoType leaveInfoType;

    /**
     * 请假开始时间
     */
    @Column(name = "leaveBeganTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date leaveBeganTime;

    /**
     * 请假结束时间
     */
    @Column(name = "leaveEndTime", type = MySqlTypeConstant.DATE)
    private Date leaveEndTime;

    /**
     * 请假图片
     */
    @Column(name = "leavePictures", type = MySqlTypeConstant.TEXT)
    private String leavePictures;

    /**
     * 入住状态
     */
    @Column(name = "checkInStatus", type = MySqlTypeConstant.INT)
    private CheckInStatus checkInStatus;

    /**
     * 销假时间
     */
    @Column(name = "eliminateTime", type = MySqlTypeConstant.DATE)
    private Date eliminateTime;

    /**
     * 请假联系人
     */
    @Column(name = "leaveContact", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String leaveContact;

    /**
     * 请假联系人电话
     */
    @Column(name = "leaveContactNumber", type = MySqlTypeConstant.VARCHAR, length = 20)
    @IsNotNull
    private String leaveContactNumber;

    /**
     * 请假事由说明
     */
    @Column(name = "leaveReason", type = MySqlTypeConstant.VARCHAR, length = 2000)
    @IsNotNull
    private String leaveReason;

    /**
     * 审核结果状态
     */
    @Column(name = "auditResult", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditResult auditResult;
}
