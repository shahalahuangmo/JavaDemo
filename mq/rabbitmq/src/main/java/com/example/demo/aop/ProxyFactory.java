package com.example.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pengnanfa
 * @date 2021/5/9 21:03
 */
public class ProxyFactory {
    private Object target;// 维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("计算开始时间");
                        // 执行目标对象方法
                        method.invoke(target, args);
                        System.out.println("计算结束时间");
                        return null;
                    }
                });
    }
}
