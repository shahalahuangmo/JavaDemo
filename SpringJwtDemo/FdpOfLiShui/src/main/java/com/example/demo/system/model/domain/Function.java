package com.example.demo.system.model.domain;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name = "function")
public class Function extends BaseModel {
    private static final long serialVersionUID = 5199200306752426433L;
    /**
     * 功能编码
     */
    @Column(name = "functionCode",type = MySqlTypeConstant.VARCHAR,length = 500)
    @IsNotNull
    private String functionCode;
    /**
     * 功能父编码
     */
    @Column(name = "functionParentCode",type = MySqlTypeConstant.VARCHAR,length = 500)
    private String functionParentCode;
    /**
     * 功能名称
     */
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 255)
    @IsNotNull
    private String name;
    /**
     * 功能层级
     */
    @Column(name = "functionLevel",type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer functionLevel;
    /**
     * 描述
     */
    @Column(name = "displayName",type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String displayName;
    /**
     * url 地址
     */
    @Column(name = "urlAddress",type = MySqlTypeConstant.VARCHAR,length = 2000)
    @IsNotNull
    private String urlAddress;
    /**
     * 序号
     */
    @Column(name = "orderId",type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer orderId;
}
