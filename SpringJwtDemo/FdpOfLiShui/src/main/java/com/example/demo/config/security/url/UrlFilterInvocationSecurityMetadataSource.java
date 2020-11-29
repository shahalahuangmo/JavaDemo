package com.example.demo.config.security.url;

import com.example.demo.config.Constants;
import com.example.demo.system.mapper.systemmapper.RoleMapper;
import com.example.demo.system.model.domain.system.Role;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    RoleMapper roleMapper;

    /**
     * 返回该url所需要的用户权限信息
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取当前请求url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // TODO 忽略url请放在此处进行过滤放行
        if ("/login".equals(requestUrl) || requestUrl.contains("logout")) {
            return null;
        }

        // 获取请求url对应的角色信息
        List<Role> roleList = roleMapper.getRoleByAccessPathUrl(requestUrl);
        List<String> roles = new LinkedList<>();
        for (Role role : roleList) {
            roles.add(role.getRoleCode());
        }
        if (!CollectionUtils.isEmpty(roles)) {
            // 保存该url对应角色权限信息
            return SecurityConfig.createList(roles.toArray(new String[roles.size()]));
        }

        // 如果数据中没有找到相应url资源则为非法访问，要求用户登录再进行操作
        return SecurityConfig.createList(Constants.ROLE_LOGIN);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
