package com.gouli.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pengnanfa
 * @date 2021/1/20 11:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class MonitorCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorCenterApplication.class, args);
    }
}
