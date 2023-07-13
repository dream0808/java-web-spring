package com.nhq.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */

@Slf4j
@Component
@Aspect
public class TimeAspect {


    @Around("execution(* com.nhq.service.*.*(..))")//切入点表达式
    public Object recordTime(ProceedingJoinPoint point) throws Throwable {
        //1、记录开始时间
        long start = System.currentTimeMillis();

        //2、调用原始方法运行
        Object result = point.proceed();

        //3、记录结束时间
        long end = System.currentTimeMillis();


        log.info(point.getSignature()+"运行时间：{}",(end-start));

        return result;
    }
}
