package com.gouli.user.biz.filter;

import com.gouli.common.core.filter.IgnoreReposeAdvice;
import com.gouli.common.core.responseresult.ResponseData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 实现ResponseBodyAdvice接口，可以对返回值在输出之前进行修改
 * @author pengnanfa
 * @since 2021-01-14
 */
@RestControllerAdvice(value={"com.gouli","org.spring"})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     *  判断支持的类型
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
        return !methodParameter.getMethod().isAnnotationPresent(IgnoreReposeAdvice.class);
    }

    /**
     * 处理返回结果，为指定数据格式
     * @param object 返回内容
     * @param methodParameter 方法参数
     * @param mediaType
     * @param aClass 泪痣
     * @param serverHttpRequest 请求内容
     * @param serverHttpResponse 返回内容
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 判断是ResponseData子类或其本身就返回Object o本身，因为有可能是接口返回时创建了ResponseData,这里避免再次封装
        if (!(object instanceof ResponseData)) {
            return new ResponseData<>(object);
        }

        return object;
    }
}
