package com.pkpm.user.api.feign;


import com.gouli.common.core.responseresult.ResponseData;
import com.pkpm.user.api.feign.impl.UsersFeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户 Feign
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@FeignClient(value = "user-server",fallback = UsersFeignError.class)
@Primary //消除警告
public interface UsersFeign {

    @GetMapping("users/index")
    ResponseData index();

    @GetMapping("users/getUser")
    ResponseData getUser();

    @GetMapping("users/addUser")
    ResponseData addUser();

    @GetMapping("users/testUser")
    ResponseData testUser();
}
