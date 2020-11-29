package com.example.demo.common.utils;

import com.example.demo.system.model.domain.system.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";
    private static final String ISS = "echisan";
    private static final String RoleLoginName = "ROLE_LOGIN";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;

    // 创建token
    public static String createToken(String username, List<Role> roles,String userId, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        List<String> roleList = new ArrayList<>();
        for (Role role: roles ) {
            roleList.add(role.getRoleCode());
        }

        // 生成jwt访问令牌
        return Jwts.builder()
                // 加密算法和密钥
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuer(ISS)
                // 用户角色
                .claim(RoleLoginName,roleList)
                .setId(userId)
                // 主题 - 存用户名
                .setSubject(username)
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    // 从token中获取用户名
    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    // 从token中获取用户角色
    public static List<String> getUserRole(String token){
        Object roles = getTokenBody(token).get(RoleLoginName);
        if(roles != null)
        {
            return  (List<String>) roles;
        }
        return null;
    }

    // 从token中获取用户Id
    public static Long getUserId(String token){
        String userId = getTokenBody(token).getId();
        if(!StringUtils.isEmpty(userId))
        {
            return  Long.valueOf(userId);
        }
        return null;
    }

    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
