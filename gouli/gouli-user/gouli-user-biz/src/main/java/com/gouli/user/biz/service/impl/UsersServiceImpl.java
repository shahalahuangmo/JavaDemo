package com.gouli.user.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouli.user.biz.beans.Users;
import com.gouli.user.biz.mapper.UsersMapper;
import com.gouli.user.biz.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pengnanfa
 * @since 2021-01-14
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    /**
     * 添加用户
     * @param userList
     * @return
     */
    @Override
    public int addUser(List<Users> userList) {
        return baseMapper.addUser(userList);
    }

    /**
     * 添加用户
     * @param userList
     * @return
     */
    @Transactional
    @Override
    public int addAndUpdateUser(List<Users> userList) {
        Users users1 = userList.get(0);
        Users users2 = userList.get(1);
        int i = baseMapper.insert(users1);
        return baseMapper.insert(users2);
    }

    /**
     * 添加用户
     * @param userList
     * @return
     */
    @Transactional
    @Override
    public int testUser(List<Users> userList) {
        Users users1 = userList.get(0);
        Users users2 = userList.get(1);
        int i = baseMapper.insert(users1);
        i =  i / 0;
        return baseMapper.insert(users2);
    }
}
