package com.example.demo.config.exception;

import com.example.demo.common.dto.output.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    /**
     * 定义要捕获的异常 可以多个 @ExceptionHandler({}) 这里直接捕获了所有的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ApiResult exceptionHandler(Exception e) {
        e.printStackTrace();
        return ApiResult.fail("服务器异常：" + e.getMessage());
    }
}
