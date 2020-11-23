package com.example.demo.config.security.login;

import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AdminAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ApiResult result;
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            result = ApiResult.fail(exception.getMessage());
        } else if (exception instanceof LockedException) {
            result = ApiResult.fail("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            result = ApiResult.fail("证书过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            result = ApiResult.fail("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            result = ApiResult.fail("账户被禁用，请联系管理员!");
        } else {
            log.error("登录失败：", exception);
            result = ApiResult.fail("登录失败!");
        }
        ResponseUtils.out(response, result);
    }
}
