package com.gouli.common.core.responseresult;


/**
 * 响应码枚举 可参考HTTP状态码的语义 这里采用了枚举构造函数的方式
 *
 * @author pengnanfa
 * @date 2021/1/15 21:58
 */
public enum ResultCodeEnum {
    /**
     * 成功
     * code 00000
     * message  成功
     */
    SUCCESS("00000", "成功"),

    /**
     * 用户端错误
     * code A0001
     * message 用户端错误
     */
    USER_ERROR("A0001", "用户端错误"),
    /**
     * 用户登录异常
     * code A0200
     * message 用户登录异常
     */
    USER_LOGIN_ERROR("A0200", "用户登录异常"),
    /**
     * 用户不存在
     * code A0201
     * message 用户不存在
     */
    USER_NOT_EXIST("A0201", "用户不存在"),
    /**
     * 用户账户被冻结
     * code A0202
     * message 用户账户被冻结
     */
    USER_ACCOUNT_LOCKED("A0202", "用户账户被冻结"),
    /**
     * 用户账户已作废
     * code A0203
     * message 用户账户已作废
     */
    USER_ACCOUNT_INVALID("A0203", "用户账户已作废"),
    /**
     * 用户名或密码错误
     * code A0210
     * message 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR("A0210", "用户名或密码错误"),
    /**
     * 用户输入密码次数超限
     * code A0211
     * message 用户输入密码次数超限
     */
    INPUT_PASSWORD_EXCEED_LIMIT("A0211", "用户输入密码次数超限"),
    /**
     * 客户端认证失败
     * code A0212
     * message 客户端认证失败
     */
    CLIENT_AUTHENTICATION_FAILED("A0212", "客户端认证失败"),
    /**
     * token无效或已过期
     * code A0230
     * message token无效或已过期
     */
    TOKEN_INVALID_OR_EXPIRED("A0230", "token无效或已过期"),
    /**
     * 验证码不存在
     * code A0213
     * message 验证码不存在
     */
    VALIDATE_EXIST("A0213", "验证码不存在"),
    /**
     * 验证码错误
     * code A0214
     * message 验证码错误
     */
    VALIDATE_ERROR("A0214", "验证码错误"),
    /**
     * 验证码过期
     * code A0215
     * message 验证码过期
     */
    VALIDATE_EXPIRED("A0215", "验证码过期"),

    /**
     * 访问权限异常
     * code A0300
     * message 访问权限异常
     */
    USER_AUTHORIZED_ERROR("A0300", "访问权限异常"),
    /**
     * 访问未授权
     * code A0301
     * message 访问未授权
     */
    USER_ACCESS_UNAUTHORIZED("A0301", "访问未授权"),

    /**
     * 用户请求参数错误
     * code A0400
     * message 用户请求参数错误
     */
    USER_REQUEST_PARAM_ERROR("A0400", "用户请求参数错误"),
    /**
     * 请求必填参数为空
     * code A0410
     * message 请求必填参数为空
     */
    USER_REQUEST_PARAM_IS_BLANK("A0410", "请求必填参数为空"),

    /**
     * 用户上传文件异常
     * code A0700
     * message 用户上传文件异常
     */
    USER_UPLOAD_FILE_ERROR("A0700", "用户上传文件异常"),
    /**
     * 用户上传文件类型不匹配
     * code A0701
     * message 用户上传文件类型不匹配
     */
    USER_UPLOAD_FILE_TYPE_NOT_MATCH("A0701", "用户上传文件类型不匹配"),
    /**
     * 用户上传文件太大
     * code A0702
     * message 用户上传文件太大
     */
    USER_UPLOAD_FILE_SIZE_EXCEEDS("A0702", "用户上传文件太大"),
    /**
     * 用户上传图片太大
     * code A0703
     * message 用户上传图片太大
     */
    USER_UPLOAD_IMAGE_SIZE_EXCEEDS("A0703", "用户上传图片太大"),

    /**
     * 失败
     * code  B0000
     * message  失败
     */
    FAILURE("B0000", "失败"),
    /**
     * 系统执行出错
     * code B0001
     * message 系统执行出错
     */
    SYSTEM_EXECUTION_ERROR("B0001", "系统执行出错"),
    /**
     * 接口调用异常
     * code B0002
     * message 接口调用异常
     */
    INTERFACE_ERROR("B0002", "接口调用异常"),
    /**
     * 系统执行超时
     * code B0100
     * message 系统执行超时
     */
    SYSTEM_EXECUTION_TIMEOUT("B0100", "系统执行超时"),
    /**
     * 系统订单处理超时
     * code B0100
     * message 系统订单处理超时
     */
    SYSTEM_ORDER_PROCESSING_TIMEOUT("B0100", "系统订单处理超时"),
    /**
     * 系统容灾功能被出发
     * code B0200
     * message 系统容灾功能被出发
     */
    SYSTEM_DISASTER_RECOVERY_TRIGGER("B0200", "系统容灾功能被出发"),
    /**
     * 系统限流
     * code B0210
     * message 系统限流
     */
    SYSTEM_LIMITING("B0210", "系统限流"),
    /**
     * 系统功能降级
     * code B0220
     * message 系统功能降级
     */
    SYSTEM_FUNCTION_DEGRADATION("B0220", "系统功能降级"),

    /**
     * 系统资源异常
     * code B0300
     * message 系统资源异常
     */
    SYSTEM_RESOURCE_ERROR("B0300", "系统资源异常"),
    /**
     * 系统资源耗尽
     * code B0310
     * message 系统资源耗尽
     */
    SYSTEM_RESOURCE_EXHAUSTION("B0310", "系统资源耗尽"),
    /**
     * 系统资源访问异常
     * code B0320
     * message 系统资源访问异常
     */
    SYSTEM_RESOURCE_ACCESS_ERROR("B0320", "系统资源访问异常"),
    /**
     * 系统读取磁盘文件失败
     * code B0321
     * message 系统读取磁盘文件失败
     */
    SYSTEM_READ_DISK_FILE_ERROR("B0321", "系统读取磁盘文件失败"),

    /**
     * 调用第三方服务出错
     * code C0001
     * message 调用第三方服务出错
     */
    CALL_THIRD_PARTY_SERVICE_ERROR("C0001", "调用第三方服务出错"),
    /**
     * 中间件服务出错
     * code C0100
     * message 中间件服务出错
     */
    MIDDLEWARE_SERVICE_ERROR("C0100", "中间件服务出错"),
    /**
     * 接口不存在
     * code C0113
     * message 接口不存在
     */
    INTERFACE_NOT_EXIST("C0113", "接口不存在"),
    /**
     * 消息服务出错
     * code C0120
     * message 消息服务出错
     */
    MESSAGE_SERVICE_ERROR("C0120", "消息服务出错"),
    /**
     * 消息投递出错
     * code C0121
     * message 消息投递出错
     */
    MESSAGE_DELIVERY_ERROR("C0121", "消息投递出错"),
    /**
     * 消息消费出错
     * code C0122
     * message 消息消费出错
     */
    MESSAGE_CONSUMPTION_ERROR("C0122", "消息消费出错"),
    /**
     * 消息订阅出错
     * code C0123
     * message 消息订阅出错
     */
    MESSAGE_SUBSCRIPTION_ERROR("C0123", "消息订阅出错"),
    /**
     * 消息分组未查到
     * code C0124
     * message 消息分组未查到
     */
    MESSAGE_GROUP_NOT_FOUND("C0124", "消息分组未查到"),

    /**
     * 数据库服务出错
     * code C0300
     * message 数据库服务出错
     */
    DATABASE_ERROR("C0300", "数据库服务出错"),
    /**
     * 表不存在
     * code C0311
     * message 表不存在
     */
    DATABASE_TABLE_NOT_EXIST("C0311", "表不存在"),
    /**
     * 列不存在
     * code C0312
     * message 列不存在
     */
    DATABASE_COLUMN_NOT_EXIST("C0312", "列不存在"),
    /**
     * 多表关联中存在多个相同名称的列
     * code C0321
     * message 多表关联中存在多个相同名称的列
     */
    DATABASE_DUPLICATE_COLUMN_NAME("C0321", "多表关联中存在多个相同名称的列"),
    /**
     * 数据库死锁
     * code C0331
     * message 数据库死锁
     */
    DATABASE_DEADLOCK("C0331", "数据库死锁"),
    /**
     * 主键冲突
     * code C0341
     * message 主键冲突
     */
    DATABASE_PRIMARY_KEY_CONFLICT("C0341", "主键冲突");

    /**
     * 响应码
     */
    private String code;

    /**
     * 消息内容描述
     */
    private String message;

    ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.message = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

