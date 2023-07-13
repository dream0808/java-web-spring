package com.nhq.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Component
@Aspect
@Slf4j
public class MyAspect1 {


    @Pointcut("execution(* com.nhq.service.impl.DeptServiceImpl.*(..))")
    public void pt(){

    }

    @Before("pt()")
    public void before(){
        log.info("Before...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("before Around...");

        Object result = joinPoint.proceed();

        log.info("after Around...");

        return result;
    }

    @After("pt()")
    public void after(){
        log.info("After...");
    }


    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("AfterReturning...");
    }


    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("AfterThrowing...");
    }
}
