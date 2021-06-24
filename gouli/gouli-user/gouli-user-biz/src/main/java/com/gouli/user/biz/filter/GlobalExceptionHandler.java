package com.gouli.user.biz.filter;

import com.gouli.common.core.constant.system.SystemConstants;
import com.gouli.common.core.excetion.CustomException;
import com.gouli.common.core.responseresult.ResponseData;
import com.gouli.common.core.responseresult.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 全局异常处理
 *
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
     * 拦截表单参数校验
     */
    @ExceptionHandler({BindException.class})
    public ResponseData bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        ResultCodeEnum.USER_REQUEST_PARAM_ERROR.setMessage(bindingResult.getFieldError().getDefaultMessage());
        return ResponseData.failed(ResultCodeEnum.USER_REQUEST_PARAM_ERROR);
    }

    /**
     * @Title: handleConstraintViolationException
     * @Description: Get方式参数验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseData handleConstraintViolationException(ConstraintViolationException ex) {
        // 获取所有错误信息
        HashSet<ConstraintViolation<?>> set = (HashSet<ConstraintViolation<?>>) ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = set.iterator();
        if (iterator.hasNext()) {
            ConstraintViolation<?> next = iterator.next();
            // 只取一个异常信息返回
            ResultCodeEnum.USER_REQUEST_PARAM_ERROR.setMessage(next.getMessageTemplate());
            return ResponseData.failed(ResultCodeEnum.USER_REQUEST_PARAM_ERROR);
        }
        return ResponseData.failed(ResultCodeEnum.USER_REQUEST_PARAM_ERROR);
    }


    /**
     * 拦截JSON参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        ResultCodeEnum.USER_REQUEST_PARAM_ERROR.setMessage(bindingResult.getFieldError().getDefaultMessage());
        return ResponseData.failed(ResultCodeEnum.USER_REQUEST_PARAM_ERROR);
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
