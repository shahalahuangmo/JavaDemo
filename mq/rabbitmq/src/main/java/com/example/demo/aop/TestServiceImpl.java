package com.example.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author pengnanfa
 * @date 2021/5/9 19:52
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public void eatCarrot() {
        System.out.println("吃萝卜");
    }

    @Override
    @GlobalErrorCatch
    public void eatMushroom() {
        System.out.println("吃蘑菇");
    }

    @Override
    public void eatCabbage() {
        System.out.println("吃白菜");
    }
}
