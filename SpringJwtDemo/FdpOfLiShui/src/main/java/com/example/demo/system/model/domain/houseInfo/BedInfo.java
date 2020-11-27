package com.example.demo.system.model.domain.houseInfo;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.BedStatus;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 楼栋信息
 */
@Data
@Table(name = "bedInfo")
public class BedInfo extends BaseOrderEntity {
    /**
     * 房间Id
     */
    @Column(name = "roomId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long roomId;

    /**
     * 床位名称
     */
    @Column(name = "bedName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String bedName;

    /**
     * 床位状态
     */
    @Column(name = "bedStatus", type = MySqlTypeConstant.INT)
    @IsNotNull
    private BedStatus bedStatus;

    /**
     * 床位说明
     */
    @Column(name = "bedContent", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String bedContent;

    /**
     * 房间床位名称（规则 楼栋/房间/床位号）
     */
    @Column(name = "houseBedName", type = MySqlTypeConstant.VARCHAR, length = 500)
    @IsNotNull
    public String houseBedName;

}
