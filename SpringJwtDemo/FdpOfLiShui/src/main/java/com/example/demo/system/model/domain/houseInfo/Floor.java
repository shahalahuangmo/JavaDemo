package com.example.demo.system.model.domain.houseInfo;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 楼栋信息
 */
@Data
@Table(name = "floor")
public class Floor extends BaseOrderEntity {
    /**
     * 楼栋Id
     */
    @Column(name = "buildingId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long buildingId;

    /**
     * 楼层名称
     */
    @Column(name = "floorName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String floorName;

    /**
     * 楼层说明
     */
    @Column(name = "floorContent", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String floorContent;

}
