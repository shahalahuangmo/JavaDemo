package com.gouli.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * AuthServerApplication
 * @author pengnanfa
 * @date 2021/1/15 14:54
 */
@SpringBootApplication(scanBasePackages = {"com.gouli.common.redis", "com.gouli"},exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
