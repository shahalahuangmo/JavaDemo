package com.example.tokendemo;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TokendemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokendemoApplication.class, args);
        // System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

}
