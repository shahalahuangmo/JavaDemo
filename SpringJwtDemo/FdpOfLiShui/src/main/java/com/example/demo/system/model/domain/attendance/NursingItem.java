package com.example.demo.system.model.domain.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 护理项目
 */
@Data
@Table(name = "nursingItem")
public class NursingItem extends BaseDateEntity {
    /**
     * 护理类别Id
     */
    @Column(name = "nursingTypeId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long nursingTypeId ;

    /**
     * 项目名称
     */
    @Column(name = "itemName", type = MySqlTypeConstant.VARCHAR,length = 250)
    @IsNotNull
    private String itemName ;

    /**
     *  简化名称
     */
    @Column(name = "shortName", type = MySqlTypeConstant.VARCHAR,length = 150)
    @IsNotNull
    private String shortName ;

    /**
     *  项目图标
     */
    @Column(name = "projectIcon", type = MySqlTypeConstant.VARCHAR,length = 150)
    @IsNotNull
    private String projectIcon ;

    /**
     * 护理项目说明
     */
    @Column(name = "itemRemark", type = MySqlTypeConstant.TEXT)
    private String itemRemark ;
}
