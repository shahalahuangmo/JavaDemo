package com.gouli.user.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gouli.common.core.page.PageInfoUtil;
import com.gouli.common.dto.output.user.UsersDTO;
import com.gouli.user.biz.beans.Users;
import com.gouli.user.biz.converter.UserConverter;
import com.gouli.user.biz.mapper.UsersMapper;
import com.gouli.user.biz.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Autowired
    private UserConverter userConverter;

    @Resource
    private UsersMapper usersMapper;

    /**
     * 添加用户
     *
     * @param userList
     * @return
     */
    @Override
    public int addUser(List<UsersDTO> userList) {
        List<Users> users = userConverter.UsersDTOToUsersList(userList);
        return baseMapper.addUser(users);
    }

    /**
     * 添加用户
     *
     * @param userList
     * @return
     */
    @Transactional
    @Override
    public int addAndUpdateUser(List<UsersDTO> userList) {
        List<Users> usersList = userConverter.UsersDTOToUsersList(userList);
        Users users1 = usersList.get(0);
        Users users2 = usersList.get(1);
        int i = baseMapper.insert(users1);
        return baseMapper.insert(users2);
    }

    /**
     * 添加用户
     *
     * @param userList
     * @return
     */
    @Transactional
    @Override
    public int testUser(List<UsersDTO> userList) {
        List<Users> usersList = userConverter.UsersDTOToUsersList(userList);
        Users users1 = usersList.get(0);
        Users users2 = usersList.get(1);
        int i = baseMapper.insert(users1);
        i = i / 0;
        return baseMapper.insert(users2);
    }

    @Override
    public IPage<UsersDTO> selectPageVo(int pageNum, int pageSize, String UserName) {
        LambdaQueryWrapper<Users> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(Users::getUsername, UserName);
        Page<Users> mapPage = new Page<>(pageNum, pageSize, true);
        IPage<Users> iPage = usersMapper.selectPage(mapPage, userLambdaQueryWrapper);
        return iPage.convert(user -> userConverter.usersToUsersDTO(user));
    }

    @Override
    public PageInfo<UsersDTO> selectPageInfo(int pageNum, int pageSize, String UserName) {
        PageHelper.startPage(1,10);
        LambdaQueryWrapper<Users> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(Users::getUsername, UserName);
        List<Users> cityList = usersMapper.selectList(userLambdaQueryWrapper);
        PageInfo<Users> pageInfoList = new PageInfo(cityList);
        PageInfo<UsersDTO> dTOPageInfo = PageInfoUtil.pageInfo2PageInfoDTO(pageInfoList, UsersDTO.class);
        return dTOPageInfo;
    }
}
