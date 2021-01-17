package com.gouli.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pengnanfa
 * @date 2021/1/16 23:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.gouli.user.biz") //扫描mapper
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
