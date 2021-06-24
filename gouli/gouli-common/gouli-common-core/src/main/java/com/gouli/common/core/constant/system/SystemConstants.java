package com.gouli.common.core.constant.system;

/**
 * 系统常量类
 * @author pengnanfa
 * @date 2021/1/15 21:58
 */
public class SystemConstants {

    /**
     *  重复值编码
     */
    public final static String DUPLICATE_CODE = "A0213";

    /**
     * 执行成功
     */
    public final static String EXECUTION_SUCCESS = "成功";

    /**
     * 执行出错
     */
    public final static String EXECUTION_FAILURE = "失败";

    /**
     * 用户请求参数错误
     */
    public final static String USER_REQUEST_PARAM_ERROR = "用户请求参数错误";

    /**
     * 请求必填参数为空
     */
    public final static String USER_REQUEST_PARAM_IS_BLANK = "请求必填参数为空";

    // region 系统日志

    /**
     * 系统执行出错
     */
    public final static String SYSTEM_ERROR_LOGGING = "系统异常！原因是：{}";

    /**
     * 业务系统出错
     */
    public final static String BUSINESS_ERROR_LOGGING = "发生业务异常！原因是：{}";

    //end region


    // region 系统异常

    /**
     * 系统执行出错
     */
    public final static String SYSTEM_EXECUTION_ERROR = "系统执行出错";

    /**
     * 系统执行超时
     */
    public final static String SYSTEM_EXECUTION_TIMEOUT = "系统执行超时";

    /**
     * 系统容灾功能被触发
     */
    public final static String SYSTEM_DISASTER_RECOVERY_TRIGGER = "系统容灾功能被触发";

    /**
     * 系统执行超时
     */
    public final static String SYSTEM_LIMITING = "系统限流";

    /**
     * 系统功能降级
     */
    public final static String SYSTEM_FUNCTION_DEGRADATION = "系统功能降级";

    // endregion

    // region 系统文件资源异常

    /**
     * 系统资源异常
     */
    public final static String SYSTEM_RESOURCE_ERROR = "系统资源异常";

    /**
     * 系统资源耗尽
     */
    public final static String SYSTEM_RESOURCE_EXHAUSTION = "系统资源耗尽";

    /**
     * 系统读取磁盘文件失败
     */
    public final static String SYSTEM_READ_DISK_FILE_ERROR = "系统读取磁盘文件失败";

    /**
     * 系统资源访问异常
     */
    public final static String SYSTEM_RESOURCE_ACCESS_ERROR = "系统资源访问异常";

    // endregion

    // region 接口异常

    /**
     * 调用第三方服务出错
     */
    public final static String CALL_THIRD_PARTY_SERVICE_ERROR = "调用第三方服务出错";

    /**
     * 中间件服务出错
     */
    public final static String MIDDLEWARE_SERVICE_ERROR = "中间件服务出错";

    /**
     * 接口不存在
     */
    public final static String INTERFACE_NOT_EXIST = "接口不存在";

    /**
     * 接口调用异常
     */
    public final static String INTERFACE_ERROR = "接口调用异常";

    // endregion

    // region 消息服务异常

    /**
     * 消息服务出错
     */
    public final static String MESSAGE_SERVICE_ERROR = "消息服务出错";

    /**
     * 消息投递出错
     */
    public final static String MESSAGE_DELIVERY_ERROR = "消息投递出错";

    /**
     * 消息消费出错
     */
    public final static String MESSAGE_CONSUMPTION_ERROR = "消息消费出错";

    /**
     * 消息订阅出错
     */
    public final static String MESSAGE_SUBSCRIPTION_ERROR = "消息订阅出错";

    /**
     * 消息分组未查到
     */
    public final static String MESSAGE_GROUP_NOT_FOUND = "消息分组未查到";

    // endregion

    // region 数据库异常

    /**
     * 数据库服务出错
     */
    public final static String DATABASE_ERROR = "数据库服务出错";

    /**
     * 表不存在
     */
    public final static String DATABASE_TABLE_NOT_EXIST = "表不存在";

    /**
     * 列不存在
     */
    public final static String DATABASE_COLUMN_NOT_EXIST = "列不存在";

    /**
     * 多表关联中存在多个相同名称的列
     */
    public final static String DATABASE_DUPLICATE_COLUMN_NAME = "多表关联中存在多个相同名称的列";

    /**
     * 数据库死锁
     */
    public final static String DATABASE_DEADLOCK = "数据库死锁";

    /**
     * 主键冲突
     */
    public final static String DATABASE_PRIMARY_KEY_CONFLICT = "主键冲突";

    // endregion

    // region 编码转换
    public  final  static  String FORMAT_NUMBER = "%04d";
    // endregion
}
