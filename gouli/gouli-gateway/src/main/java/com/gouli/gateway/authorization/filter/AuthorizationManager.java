package com.gouli.gateway.authorization.filter;

import cn.hutool.core.util.StrUtil;
import com.gouli.common.core.constant.auth.AuthConstants;
import com.gouli.gateway.authorization.config.ResourceServerConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 *
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@Component
@AllArgsConstructor
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String path = request.getURI().getPath();
        PathMatcher pathMatcher = new AntPathMatcher();

        // TODO 忽略url请放在此处进行过滤放行
        for (String item : ResourceServerConfig.EXCLUDED_AUTH_PAGES) {
            if (pathMatcher.match(item, path)) {
                return Mono.just(new AuthorizationDecision(true));
            }
        }

        // token为空拒绝访问
        String token = request.getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
        if (StrUtil.isBlank(token)) {
            return Mono.just(new AuthorizationDecision(false));
        }

        return Mono.just(new AuthorizationDecision(true));

       /*     // 从缓存取资源权限角色关系列表
        // Map<Object, Object> resourceRolesMap = redisTemplate.opsForHash().entries(AuthConstants.RESOURCE_ROLES_KEY);
        Map<Object, Object> resourceRolesMap = new HashMap<>();
        resourceRolesMap.put("/authentication/auth/token", AuthConstants.AUTHORITY_PREFIX + "admin");
        //resourceRolesMap.put("/provider/hello/index",AuthConstants.AUTHORITY_PREFIX + "client");
        Iterator<Object> iterator = resourceRolesMap.keySet().iterator();

        // 请求路径匹配到的资源需要的角色权限集合authorities统计
        Set<String> authorities = new HashSet<>();
        while (iterator.hasNext()) {
            String pattern = (String) iterator.next();
            if (pathMatcher.match(pattern, path)) {
                authorities.addAll(Convert.toList(String.class, resourceRolesMap.get(pattern)));
            }
        }

        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(roleId -> {
                    // roleId是请求用户的角色(格式:ROLE_{roleId})，authorities是请求资源所需要角色的集合
                    log.info("访问路径：{}", path);
                    log.info("用户角色信息：{}", roleId);
                    log.info("资源需要权限authorities：{}", authorities);
                    return authorities.contains(roleId);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));*/
        //return authorizationDecisionMono;
    }

}



