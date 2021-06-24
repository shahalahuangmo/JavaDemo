package com.gouli.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class GateWaySeverApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWaySeverApplication.class, args);
    }
}
