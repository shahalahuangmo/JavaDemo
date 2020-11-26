package com.example.demo.system.model.domain;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name = "bedInfo")
public class BedInfo  extends BaseOrderEntity {
    /**
     * 访问名称
     */
    @Column(name = "accessName",type = MySqlTypeConstant.VARCHAR,length = 500)
    @IsNotNull
    private String bedName;

    /**
     * 描述
     */
    @Column(name = "displayName",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String displayName;
}
