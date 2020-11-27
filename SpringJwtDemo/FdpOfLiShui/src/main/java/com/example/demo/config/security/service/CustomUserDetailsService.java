package com.example.demo.config.security.service;

import com.example.demo.config.security.dto.SecurityUser;
import com.example.demo.system.mapper.basemapper.UserMapper;
import com.example.demo.system.mapper.basemapper.UserRoleMapper;
import com.example.demo.system.model.domain.system.Role;
import com.example.demo.system.model.domain.system.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义userDetailsService - 认证用户详情
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 根据账号获取用户信息
     *
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> userList = userMapper.getUserByUserName(username);
        User user;
        if (!CollectionUtils.isEmpty(userList)) {
            user = userList.get(0);
        } else {
            throw new UsernameNotFoundException("用户不存在!");
        }

        return new SecurityUser(user, getUserRoles(user.getId()));
    }

    /**
     * 根据token获取用户权限与基本信息
     *
     * @param token
     * @return
     */
    public SecurityUser getUserByToken(String token) {
        User user = userMapper.getUserByToken(token);
        return user != null ? new SecurityUser(user, getUserRoles(user.getId())) : null;
    }

    /**
     * 根据用户id获取角色信息
     *
     * @param userId
     * @return
     */
    private List<Role> getUserRoles(long userId) {
        List<Role> userRoles = userRoleMapper.getRoleByUserId(userId);
        return userRoles;
    }
}
