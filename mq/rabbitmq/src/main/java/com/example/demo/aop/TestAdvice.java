package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author pengnanfa
 * @date 2021/5/9 19:52
 */
@Aspect
@Component
public class TestAdvice {
    // 1. 定义所有带有 GlobalErrorCatch 的注解的方法为 Pointcut
    @Pointcut("@annotation(com.example.demo.aop.GlobalErrorCatch)")
    private void globalCatch() {
    }

    // 2. 将 around advice 作用于 globalCatch(){} 此 PointCut
    @Around("globalCatch()")
    public Object handlerGlobalResult(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Exception e) {
            System.out.println("执行错误" + e);
            return "系统错误";
        }
    }

}