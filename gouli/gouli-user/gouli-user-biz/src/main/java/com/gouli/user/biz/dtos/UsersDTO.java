package com.gouli.user.biz.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 * @author pengnanfa
 * @date 2021/1/14 16:15
 */
@ApiModel("用户实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    @ApiModelProperty("用户Id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户是否开启")
    private Boolean enabled;

    public UsersDTO(String username,String password){
        this.username = username;
        this.password = password;
        this.enabled = true;
    }
}
