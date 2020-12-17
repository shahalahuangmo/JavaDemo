package com.example.demo.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target  作用域(作用在方法上,类上,或是属性上)
 * @Retention 运行周期
 * @interface 定义注解
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //自定义注解的属性
    int id() default 0;
    String name() default "默认名称";
    String[]arrays();
    String title() default "默认标题";
}
