package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//这里需要使用 tk.mybatis.spring.annotation.MapperScan 替换 org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.example.demo.system.mapper")
public class DemoApplication {

    static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
