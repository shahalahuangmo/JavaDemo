package com.example.demo.service;

import com.example.demo.common.dto.input.UserInfo;
import com.example.demo.common.utils.JwtTokenUtils;
import com.example.demo.common.utils.PasswordUtils;
import com.example.demo.system.mapper.systemmapper.UserMapper;
import com.example.demo.system.model.domain.system.User;
import com.sun.istack.internal.NotNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.sql.Date;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper UserMapper;

    /**
     *  插入用户数据
     * @param userInfo
     * @return
     */
    public int insertUser(@NotNull  UserInfo userInfo){
        User user = new User();
        // 加密密码
        user.setPassword(PasswordUtils.encodePassword(userInfo.getPassword(),userInfo.getUsername()));
        user.setToken(userInfo.getPassword());
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setPhoneNumber(userInfo.getPhoneNumber());
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setDelete(false);
        user.setDeleteTime(null);
        user.setDeleter(null);
        Long creator = JwtTokenUtils.getUserId(userInfo.getToken());
        user.setCreator(creator);
        return UserMapper.insertUser(user);
    }

    /**
     * 更新用户密码
     * @param userInfo
     * @return
     */
    public int updateUserPassWord(@NotNull  UserInfo userInfo) {
/*        // 获取当前登录用户信息(注意：没有密码的)
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();*/
        // 通过用户名获取到用户信息（获取密码）
        List<User> userList = UserMapper.getUserByUserName(userInfo.getUsername());
        User user;
        if (!CollectionUtils.isEmpty(userList)) {
            user = userList.get(0);
        } else {
            throw new UsernameNotFoundException("用户不存在!");
        }
        // 判断输入的旧密码是正确
        if (user.getPassword().equals(userInfo.getPassword())) {
            // 不要忘记加密新密码
            return UserMapper.updatePassword(user.getId(), PasswordUtils.encodePassword(userInfo.getNewPassWord(),user.getUsername()));
        }
        return 0;
    }

}
