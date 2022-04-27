package com.nanfa.domaindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.nanfa.domaindemo", "com.alibaba.cola" })
@MapperScan("com.nanfa.domaindemo.gatewayimpl.database")
public class DomainDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainDemoApplication.class, args);
    }

}
