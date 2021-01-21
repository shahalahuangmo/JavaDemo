package com.gouli.user.biz.filter;

import com.gouli.common.core.constant.system.SystemConstants;
import com.gouli.common.core.excetion.CustomException;
import com.gouli.common.core.responseresult.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author pengnanfa
 * @since 2021-01-14
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    public ResponseData customExceptionHandler(CustomException e) {
        log.info(SystemConstants.BUSINESS_ERROR_LOGGING, e.getErrorMsg());
        return ResponseData.failed(e.getErrorCode(), e.getErrorMsg());
    }


    /**
     * 未捕获的所有的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseData exceptionHandler(Exception e) {
        log.error(SystemConstants.SYSTEM_ERROR_LOGGING, e.getMessage());
        return ResponseData.error();
    }
}
