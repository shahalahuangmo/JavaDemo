package com.gouli.common.core.web;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 *  Web 配置 ResourceHandlerRegistry 帮助类
 * @author pengnanfa
 * @date 2021/1/15 23:54
 */
public class ResourceHandlerRegistryUtils {

    public static void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }
}
