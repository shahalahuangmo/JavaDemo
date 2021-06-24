package com.gouli.user.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.gouli.common.dto.output.user.UsersDTO;
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

    int addUser(List<UsersDTO> users);

    int addAndUpdateUser(List<UsersDTO> users);

    int testUser(List<UsersDTO> users);

    IPage<UsersDTO> selectPageVo(int pageNum,int pageSize,String UserName);

    PageInfo<UsersDTO> selectPageInfo(int pageNum, int pageSize, String UserName);
}
