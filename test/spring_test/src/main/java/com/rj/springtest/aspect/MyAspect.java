package com.rj.springtest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 注解处理类
 * */
@Component
@Aspect
public class MyAspect {
//    @Pointcut("execution(* com.rj.springtest.service.*.*(..))") // 匹配service下所有类的所有方法所有参数
    @Pointcut("execution(* com.rj.springtest.annotation.MyAnnotation.*(..))")
    public void point() {
    }

    @Around("point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("进入around方法 start -----");
        try {
            proceedingJoinPoint.proceed();//执行切入点的方法体
            System.out.println("around 方法执行完毕...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("point()")
    public void before() {
        System.out.println("进入before方法 ");
    }

    @After("point()")
    public void after(JoinPoint joinPoint) {
        System.out.println("进入after方法 ");
    }

    @AfterReturning("point()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("进入afterReturning方法 start ");
    }

    @AfterThrowing("point()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("进入afterThrowing方法 start ");
    }
}
