package com.example.demo.system.model.domain.incident;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.EventLevel;
import com.example.demo.system.model.value.EventState;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 不良事件
 */
@Data
@Table(name = "adverseEvent")
public class AdverseEvent extends FuLLBaseDateEntity {
    /**
     * 用户ID
     */
    @Column(name = "userId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long userId;

    /**
     * 事件名称
     */
    @Column(name = "eventName", type = MySqlTypeConstant.VARCHAR, length = 500)
    @IsNotNull
    private String eventName;
    /**
     * 事件状态
     */
    @Column(name = "eventState", type = MySqlTypeConstant.INT)
    @IsNotNull
    private EventState eventState;
    /**
     * 事件级别
     */
    @Column(name = "eventLevel", type = MySqlTypeConstant.INT)
    @IsNotNull
    private EventLevel eventLevel;

    /**
     * 护工用户姓名(冗余),记录性数据,不随用户姓名修改而变化
     */
    @Column(name = "nursingUserName", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String nursingUserName;
    /**
     * 处理时间
     */
    @Column(name = "handlerTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date handlerTime;
    /**
     * 处理意见
     */
    @Column(name = "handlerResult", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String handlerResult;
    /**
     * 处理小时数
     */
    @Column(name = "handlerHour", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer handlerHour;
    /**
     * 入托人ID
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;
    /**
     * 床位名称(冗余),记录性数据,不随床位更换而变化
     */
    @Column(name = "houseBedName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String houseBedName;
    /**
     * 事件图片
     */
    @Column(name = "picture", type = MySqlTypeConstant.TEXT)
    private String picture;
    /**
     * 事件描述
     */
    @Column(name = "eventContent", type = MySqlTypeConstant.TEXT)
    private String eventContent;
    /**
     * 发生时间
     */
    @Column(name = "eventTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date eventTime;
    /**
     * 残疾人姓名
     */
    @Column(name = "userName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String userName;

}
