package com.rj.springtest.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * */
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
@Target(ElementType.METHOD) // //作用于方法
public @interface MyAnnotation {
    String name() default "默认姓名";
    String data();
    int age() default 27;
}
