package com.example.demo.config.security.jwtfilter;

import com.example.demo.common.dto.input.UserInfo;
import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.common.utils.JwtTokenUtils;
import com.example.demo.common.utils.PasswordUtils;
import com.example.demo.common.utils.ResponseUtils;
import com.example.demo.config.security.dto.SecurityUser;
import com.example.demo.system.mapper.basemapper.UserMapper;
import com.example.demo.system.model.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  JWT 验证Filter
 */

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private  UserMapper userMapper;
    private  AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

     /**
     *  验证设置用户登录信息
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        // 从输入流中获取到登录的信息
        try {
            UserInfo loginUser = new ObjectMapper().readValue(request.getInputStream(), UserInfo.class);
            List<User> userList = userMapper.getUserByUserName(loginUser.getUsername());
            User user;
            if(!CollectionUtils.isEmpty(userList))
            {
                user = userList.get(0);
                boolean isValid = PasswordUtils.isValidPassword(user.getPassword(),PasswordUtils.encodePassword(loginUser.getPassword(),loginUser.getUsername()));
                // 验证密码
                if (!isValid) {
                    throw new BadCredentialsException("密码错误！");
                }
            }else {
                throw new BadCredentialsException("密码错误！");
            }

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // 查看源代码会发现调用getPrincipal()方法会返回一个实现了`UserDetails`接口的对象
        // 所以就是JwtUser啦
        SecurityUser jwtUser = (SecurityUser) authResult.getPrincipal();
        System.out.println("jwtUser:" + jwtUser.toString());
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(),jwtUser.getRoleList(), false);

        List<User> userList = userMapper.getUserByUserName(jwtUser.getCurrentUserInfo().getUsername());
        User user;
        if(!CollectionUtils.isEmpty(userList))
        {
            user = userList.get(0);
            user.setToken(token);
            userMapper.updateUserToken(user.getId(),token);
        }

        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的格式应该是 `Bearer token`
        // response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        ResponseUtils.out(response, ApiResult.ok("登录成功",JwtTokenUtils.TOKEN_PREFIX + token));
    }

    // 这是验证失败时候调用的方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        //response.getWriter().write("authentication failed, reason: " + failed.getMessage());
        ResponseUtils.out(response, ApiResult.fail("authentication failed, reason: " + failed.getMessage()));
    }
}