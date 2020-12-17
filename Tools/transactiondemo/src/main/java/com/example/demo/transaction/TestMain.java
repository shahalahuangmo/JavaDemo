package com.example.demo.transaction;

import java.lang.reflect.Method;

public class TestMain {

    @MyAnnotation(name="吴磊",arrays = {"2","3"})
    public  void aMethod () {}

    public  void bMethod () {}

    public static void main(String[] args) throws ClassNotFoundException {
        //1. 反射获取到类信息
        Class<?> forName = Class.forName("com.example.demo.transaction.TestMain");
        //2. 获取到当前类（不包含继承）所有的方法
        Method[] declaredMethods = forName.getDeclaredMethods();
        //3. 遍历每个方法的信息
        for (Method method : declaredMethods) {
            System.out.println("方法名称:" + method.getName());
            //4. 获取方法上面的注解
            MyAnnotation annotation = method.getDeclaredAnnotation(MyAnnotation.class);
            if(annotation == null) {
                System.out.println("该方法上没有加注解....");
            }else {
                System.out.println("Id:" + annotation.id());
                System.out.println("Name:" + annotation.name());
                System.out.println("Arrays:" + annotation.arrays());
                System.out.println("Title:" + annotation.title());
            }
            System.out.println("--------------------------");
        }
    }
}
