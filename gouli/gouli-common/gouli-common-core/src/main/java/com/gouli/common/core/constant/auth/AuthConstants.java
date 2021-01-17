package com.gouli.common.core.constant.auth;

/**
 * 用户权限常量类
 * @author pengnanfa
 * @date 2021/1/15 21:58
 */
public  class AuthConstants {

    // region JWT

    /**
     * JWT存储权限前缀
     */
    public final static String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    public final static String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 认证信息Http请求头
     */
    public final static String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    public final static String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * JWT载体key
     */
    public final static String JWT_PAYLOAD_KEY = "payload";

    /**
     * Redis缓存权限规则key
     */
    public final static String RESOURCE_ROLES_KEY = "auth:resourceRoles";

    // endregion


    // region 用户登录
    /**
     * 用户登录异常
     */
    public final static String  USER_LOGIN_ERROR = "用户登录异常";

    /**
     * 用户端错误
     */
    public final static String  USER_ERROR = "用户端错误";

    /**
     * 用户不存在
     */
    public final static String  USER_NOT_EXIST = "用户不存在";

    /**
     * 用户账户被冻结
     */
    public final static String  USER_ACCOUNT_LOCKED = "用户账户被冻结";

    /**
     * 用户账户已作废
     */
    public final static String  USER_ACCOUNT_INVALID = "用户账户已作废";

    /**
     * 验证码不存在
     */
    public final static String  VALIDATE_EXIST = "验证码不存在";

    /**
     * 验证码错误
     */
    public final static String  VALIDATE_ERROR = "验证码错误";

    /**
     * 验证码错误
     */
    public final static String  VALIDATE_EXPIRED = "验证码过期";

    /**
     * 用户名或密码错误
     */
    public final static String  USERNAME_OR_PASSWORD_ERROR = "用户名或密码错误";

    /**
     * 用户输入密码次数超限
     */
    public final static String  INPUT_PASSWORD_EXCEED_LIMIT = "用户输入密码次数超限";

    /**
     * 客户端认证失败
     */
    public final static String  CLIENT_AUTHENTICATION_FAILED = "客户端认证失败";

    /**
     * token无效或已过期
     */
    public final static String  TOKEN_INVALID_OR_EXPIRED = "token无效或已过期";

    // region JWT 常用变量

    // region 用户鉴权

    /**
     * 访问权限异常
     */
    public final static String  USER_AUTHORIZED_ERROR = "访问权限异常";

    /**
     * 访问未授权
     */
    public final static String  USER_ACCESS_UNAUTHORIZED = "访问未授权";
    
    // endregion

}
