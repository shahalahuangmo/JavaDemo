package com.pkpm.user.api.feign;


import com.gouli.common.core.responseresult.ResponseData;
import com.gouli.common.dto.output.user.UsersDTO;
import com.pkpm.user.api.feign.impl.UsersFeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户 Feign
 *
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@FeignClient(value = "user-server", fallback = UsersFeignError.class)
@Primary
public interface UsersFeign {

    /**
     *  首页
     * @return
     */
    @GetMapping("users/index")
    ResponseData<String> index();

    /**
     * 获取用户
     * @return
     */
    @GetMapping("users/getUser")
    ResponseData<UsersDTO> getUser();

    /**
     * 添加用户
     * @return
     */
    @GetMapping("users/addUser")
    ResponseData<Integer> addUser();

    /**
     * 测试用户
     * @return
     */
    @GetMapping("users/testUser")
    ResponseData testUser();
}
