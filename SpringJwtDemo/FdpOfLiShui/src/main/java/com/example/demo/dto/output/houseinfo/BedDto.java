package com.example.demo.dto.output.houseinfo;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.BedStatus;
import lombok.Data;

@Data
public class BedDto extends BaseOrderEntity {

    /**
     * 房间Id
     */
    private Long roomId;

    /**
     * 床位名称
     */
    private String bedName;

    /**
     * 床位状态
     */
    private BedStatus bedStatus;

    /**
     * 床位状态描述
     */
    public String bedStatusDisplayName;

    /**
     * 床位说明
     */
    private String bedContent;

    /**
     * 房间床位名称（规则 楼栋/房间/床位号）
     */
    public String houseBedName;
}
