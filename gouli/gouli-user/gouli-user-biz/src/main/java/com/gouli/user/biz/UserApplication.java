package com.gouli.user.biz;

import com.gouli.common.mysql.EnableDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pengnanfa
 * @date 2021/1/16 23:50
 */
@EnableDiscoveryClient
@EnableDataSource
@SpringBootApplication(scanBasePackages = {"com.gouli.common.redis", "com.gouli"})
@MapperScan("com.gouli.user.biz.mapper")
@MapperScan("com.gouli.user.biz.repository")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
