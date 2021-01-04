package com.pengnanfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// 包含了 @EnableZuulServer，设置该类是网关的启动类。
@EnableZuulProxy
// 可以帮助 Spring Boot 应用将所有符合条件的@Configuration 配置加载到当前 Spring Boot 创建并使用的 IoC 容器中。
@EnableAutoConfiguration
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
