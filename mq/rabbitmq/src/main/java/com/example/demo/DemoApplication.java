package com.example.demo;

import com.example.demo.aop.MyMethodInterceptor;
import com.example.demo.aop.ProxyFactory;
import com.example.demo.aop.RealSubject;
import com.example.demo.aop.Subject;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author pengnanfa
 * @date 2021/5/9 20:03
 */

public class DemoApplication {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass());
        Subject subject = (Subject) new ProxyFactory(realSubject).getProxyInstance();
        System.out.println(subject.getClass());
        subject.request();


        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(RealSubject.class);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        //这里的creat方法就是正式创建代理类
        RealSubject proxyDog = (RealSubject) enhancer.create();
        System.out.println(proxyDog.getClass());
        //调用代理类的eat方法
        proxyDog.request();
    }
}
