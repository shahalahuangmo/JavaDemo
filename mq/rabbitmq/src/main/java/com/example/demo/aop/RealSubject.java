package com.example.demo.aop;

/**
 * @author pengnanfa
 * @date 2021/5/9 21:03
 */
// 委托类
public class RealSubject implements Subject {
    @Override
    public void request() {
        // 卖房
        System.out.println("卖房");
    }
}
