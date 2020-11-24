package com.example.demo.config.security.login;

import com.example.demo.common.utils.JwtTokenUtils;
import com.example.demo.common.utils.PasswordUtils;
import com.example.demo.config.security.dto.SecurityUser;
import com.example.demo.config.security.service.CustomUserDetailsService;
import com.example.demo.system.mapper.basemapper.UserMapper;
import com.example.demo.system.model.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 自定义认证处理
 */
@Slf4j
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Resource
    CustomUserDetailsService userDetailsService;

    @Resource
    private UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SecurityUser userInfo = (SecurityUser) userDetailsService.loadUserByUsername(userName);
        boolean isValid = PasswordUtils.isValidPassword(password, userInfo.getPassword(), userInfo.getCurrentUserInfo().getUsername());
        // 验证密码
        if (!isValid) {
            throw new BadCredentialsException("密码错误！");
        }

        // 前后端分离情况下 处理逻辑...
        // 更新登录令牌
        String token = JwtTokenUtils.createToken(userInfo.getUsername(),userInfo.getRoleList(), false);
        //String token = PasswordUtils.encodePassword(System.currentTimeMillis() + userInfo.getCurrentUserInfo().getPassword(), userInfo.getCurrentUserInfo().getUsername());
        User user = userMapper.getUserById(userInfo.getCurrentUserInfo().getId());
        user.setToken(token);
        userMapper.updateUserToken(user.getId(),user.getToken());
        userInfo.getCurrentUserInfo().setToken(token);
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
