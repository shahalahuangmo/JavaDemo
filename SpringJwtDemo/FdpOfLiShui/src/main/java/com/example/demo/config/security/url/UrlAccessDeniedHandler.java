package com.example.demo.config.security.url;

import com.example.demo.common.dto.output.ApiResult;
import com.example.demo.common.utils.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证url权限 - 登录后访问接口无权限 - 自定义403无权限响应内容
 */
@Component
public class UrlAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseUtils.out(response, ApiResult.fail(403, accessDeniedException.getMessage()));
    }
}
