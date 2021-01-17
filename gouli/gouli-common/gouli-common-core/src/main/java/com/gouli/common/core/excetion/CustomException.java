package com.gouli.common.core.excetion;


import com.gouli.common.core.responseresult.ResultCodeEnum;

/**
 * 自定义异常类
 *
 * @author pengnanfa
 * @date 2021/1/15 21:58
 */
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomException(ResultCodeEnum resultCode) {
        super(resultCode.getMessage());
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMessage();
    }

    public CustomException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public CustomException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException() {
        super();
    }

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
