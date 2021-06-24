package com.gouli.authentication.filter;

import com.gouli.common.core.constant.system.SystemConstants;
import com.gouli.common.core.excetion.CustomException;
import com.gouli.common.core.responseresult.ResponseData;
import com.gouli.common.core.responseresult.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler  {

    /**
     * 处理自定义的业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    public  ResponseData customExceptionHandler(CustomException e){
        log.info(SystemConstants.BUSINESS_ERROR_LOGGING,e.getErrorMsg());
        return ResponseData.failed(e.getErrorCode(),e.getErrorMsg());
    }

     /**
     * 用户名和密码异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidGrantException.class)
    public ResponseData invalidGrantExceptionHandler(InvalidGrantException e) {
        log.error(SystemConstants.BUSINESS_ERROR_LOGGING,e.getMessage());
        return ResponseData.failed(ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR);
    }

    /**
     * 账户异常(禁用、锁定、过期)
     * @param e
     * @return
     */
    @ExceptionHandler({InternalAuthenticationServiceException.class})
    public ResponseData internalAuthenticationServiceExceptionHandler(InternalAuthenticationServiceException e) {
        log.error(SystemConstants.BUSINESS_ERROR_LOGGING,e.getMessage());
        return ResponseData.failed(ResultCodeEnum.USER_LOGIN_ERROR);
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
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseData exceptionHandler(Exception e) {
        log.error(SystemConstants.SYSTEM_ERROR_LOGGING,e.getMessage());
        return ResponseData.error();
    }
}
