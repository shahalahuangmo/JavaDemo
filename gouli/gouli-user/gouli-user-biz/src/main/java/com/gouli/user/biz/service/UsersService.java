package com.gouli.user.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouli.user.biz.beans.Users;

import java.util.List;

/**
 * <p>
 * 用户表	 服务类
 * </p>
 *
 * @author pengnanfa
 * @since 2021-01-14
 */
public interface UsersService extends IService<Users> {

    int addUser(List<Users> users);

    int addAndUpdateUser(List<Users> users);

    int testUser(List<Users> users);
}
