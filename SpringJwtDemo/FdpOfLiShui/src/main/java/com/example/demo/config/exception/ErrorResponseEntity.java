package com.example.demo.config.exception;

/**
 * 异常信息模板
 */
public class ErrorResponseEntity {

    private int code;
    private String message;

    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
    // 省略 get/set
}
