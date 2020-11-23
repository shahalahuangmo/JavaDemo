package com.example.demo.common.enumeration;

/**
 *  响应码枚举 可参考HTTP状态码的语义 这里采用了枚举构造函数的方式
 * 1、需要在枚举实例后面加上分号，然后再写构造函数等
 * 2、枚举实例必须在前面
 * 3、定义枚举的构造器方法带参,只能为private
 */
public enum ResultCode {
    //成功
    SUCCESS( 200, "SUCCESS" ),

    //失败
    FAILURE( 400, "FAILURE" ),

    //未认证（签名错误、token错误）
    UNAUTHORIZED( 401, "未认证或Token失效" ),

    //未通过认证
    USER_UNAUTHORIZED( 402, "用户名或密码不正确" ),

    //接口不存在
    NOT_FOUND( 404, "接口不存在" ),

    //服务器内部错误
    INTERNAL_SERVER_ERROR( 500, "服务器内部错误" );

    /**
     * 响应码
     */
    private  int code;

    /**
     * 消息内容描述
     */
    private  String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
