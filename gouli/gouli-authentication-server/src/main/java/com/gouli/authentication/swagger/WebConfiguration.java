package com.gouli.authentication.swagger;

import com.gouli.common.core.web.ResourceHandlerRegistryUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebConfiguration 配置类
 * 处理SpringBoot统一返回处理遇到的问题cannot be cast to java.lang.String
 * @author pengnanfa
 * @date 2021/1/15 14:54
 */
@EnableWebMvc // 缺点是会屏蔽掉springboot默认的其他mvc配置，比如ExceptionHandler、ExceptionResolver等）
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
   @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistryUtils.addResourceHandlers(registry);
    }
}
