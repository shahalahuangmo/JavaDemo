package com.pkpm.user.api.feign.impl;


import com.gouli.common.core.responseresult.ResponseData;
import com.gouli.common.core.responseresult.ResultCodeEnum;
import com.pkpm.user.api.feign.UsersFeign;
import org.springframework.stereotype.Component;

/**
 * 用户接口异常处理
 * @author pengnanfa
 * @date 2021/1/15 9:25
 */
@Component
public class UsersFeignError implements UsersFeign {
    @Override
    public ResponseData index() {
        return ResponseData.failed(ResultCodeEnum.INTERFACE_ERROR);
    }

    @Override
    public ResponseData getUser() {
        return ResponseData.failed(ResultCodeEnum.INTERFACE_ERROR);
    }

    @Override
    public ResponseData addUser() {
        return ResponseData.failed(ResultCodeEnum.INTERFACE_ERROR);
    }

    @Override
    public ResponseData testUser() {
        return ResponseData.failed(ResultCodeEnum.INTERFACE_ERROR);
    }
}
