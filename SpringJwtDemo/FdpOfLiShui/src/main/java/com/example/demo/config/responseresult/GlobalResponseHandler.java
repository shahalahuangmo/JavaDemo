package com.example.demo.config.responseresult;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.dto.output.ApiResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *  实现ResponseBodyAdvice接口，可以对返回值在输出之前进行修改
 */

@RestControllerAdvice
public class GlobalResponseHandler  implements ResponseBodyAdvice<Object> {

    /**
     *  //判断支持的类型
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 检查注解是否存在，存在则忽略拦截
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreReposeAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreReposeAdvice.class)) {
            return false;
        }
        return true;
    }


    /**
     * 处理返回结果，为指定数据格式
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 判断为null构建ResponseData对象进行返回
        if (o == null) {
            return ApiResult.ok();
        }
        // 判断是ResponseData子类或其本身就返回Object o本身，因为有可能是接口返回时创建了ResponseData,这里避免再次封装
        if (o instanceof ApiResult) {
            return (ApiResult) o;
        }
        // String特殊处理，否则会抛异常
        if (o instanceof String) {
            return JSON.toJSON(ApiResult.ok("SUCCESS",o)).toString();
        }
        return ApiResult.ok("SUCCESS",o);
    }
}
