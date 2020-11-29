package com.example.demo.system.model.domain.attendance;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 护理类别
 */
@Data
@Table(name = "nursingType")
public class NursingType extends BaseOrderEntity {

    /**
     * 护理项目名称
     */
    @Column(name = "typeName", type = MySqlTypeConstant.VARCHAR,length = 250)
    @IsNotNull
    private String typeName ;

    /**
     * 标签颜色
     */
    @Column(name = "labelColor", type = MySqlTypeConstant.VARCHAR,length = 250)
    @IsNotNull
    private String labelColor ;

    /**
     * 护理项目说明
     */
    @Column(name = "typeRemark", type = MySqlTypeConstant.TEXT)
    private String typeRemark ;
}
