package com.example.demo.system.common;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseEntity  extends BaseModel {

    private static final long serialVersionUID = 5199200306752426433L;

    /**
     * 主键Id
     */
    @Column(name = "id",type = MySqlTypeConstant.BIGINT)
    @IsKey
    @IsAutoIncrement
    private long id;
}
