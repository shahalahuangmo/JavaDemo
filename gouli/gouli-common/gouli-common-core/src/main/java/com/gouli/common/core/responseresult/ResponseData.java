package com.gouli.common.core.responseresult;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果
 *
 * @param <T>
 * @author pengnanfa
 * @date 2021/1/15 21:58
 */
@Data
public class ResponseData<T> implements Serializable {

    /**
     *  返回成功结果
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> success() {
        return success(null);
    }

    /**
     *  返回成功结果
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> success(T data) {
        return new ResponseData(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     *  返回失败结果
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> failed() {
        return new ResponseData(ResultCodeEnum.FAILURE.getCode(), ResultCodeEnum.FAILURE.getMessage(), null);
    }

    /**
     * 返回失败结果
     * @param code 消息码
     * @param msg  提示信息
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> failed(String code, String msg) {
        return new ResponseData(code, msg, null);
    }

    /**
     * 返回失败结果
     * @param resultCode 响应码枚举
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> failed(ResultCodeEnum resultCode) {
        return new ResponseData(resultCode.getCode(), resultCode.getMessage(), null);
    }

    /**
     * 返回错误结果
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> error() {
        return new ResponseData(ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getCode(), ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getMessage(), null);
    }

    /**
     * 构建返回结果
     * @param resultCode 响应码枚举
     * @param data 返回数据的数据内容
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> build(ResultCodeEnum resultCode, T data) {
        return build(resultCode.getCode(), resultCode.getMessage(), data);
    }

    /**
     * 构建返回结果
     * @param code 消息码
     * @param msg  提示信息
     * @param data 返回数据的数据内容
     * @param <T> 返回数据的数据类型
     * @return
     */
    public static <T> ResponseData<T> build(String code, String msg, T data) {
        return new ResponseData(code, msg, data);
    }


    public ResponseData(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseData(T data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = ResultCodeEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public ResponseData() {
    }

    /**
     * 消息码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;
}
