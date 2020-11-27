package com.example.demo.system.model.domain.houseInfo;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.RoomType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 楼栋信息
 */
@Data
@Table(name = "room")
public class Room extends BaseOrderEntity {
    /**
     * 楼层Id
     */
    @Column(name = "floorId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long floorId;

    /**
     * 房间名称
     */
    @Column(name = "roomName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String roomName;

    /**
     * 房间类型
     */
    @Column(name = "roomType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private RoomType roomType;

    /*  *//**
     * 房间状态 正常，维修，停用，满员
     *//*
    @Column(name = "roomStatus", type = MySqlTypeConstant.INT)
    @IsNotNull
    private RoomStatus roomStatus;*/

    /**
     * 楼层说明
     */
    @Column(name = "roomContent", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String roomContent;

}
