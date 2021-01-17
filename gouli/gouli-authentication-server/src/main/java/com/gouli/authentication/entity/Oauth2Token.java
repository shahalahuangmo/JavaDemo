package com.gouli.authentication.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户Token 信息
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@ApiModel("用户Token 信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Oauth2Token {

    @ApiModelProperty("访问令牌")
    private String token;

    @ApiModelProperty("刷新令牌")
    private String refreshToken;

    @ApiModelProperty("有效时间(秒)")
    private int expiresIn;
}
