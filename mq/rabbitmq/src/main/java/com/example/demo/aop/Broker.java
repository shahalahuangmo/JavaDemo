package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author pengnanfa
 * @date 2021/5/9 20:35
 */
@Component
@Aspect
class Broker {

    @Pointcut("execution(* com.example.demo.aop.Landlord.service())")
    public void lService() {
    }


    @Before("lService()")
    public void before() {
        System.out.println("带租客看房");
        System.out.println("谈价格");
    }

    @After("lService()")
    public void after() {
        System.out.println("交钥匙");
    }
}
