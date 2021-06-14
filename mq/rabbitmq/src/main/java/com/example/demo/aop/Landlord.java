package com.example.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author pengnanfa
 * @date 2021/5/9 20:35
 */
@Component("landlord")
public class Landlord {

    public void service() {
        // 仅仅只是实现了核心的业务功能
        System.out.println("签合同");
        System.out.println("收房租");
    }
}
