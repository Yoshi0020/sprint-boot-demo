package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass().getPackage().getName());

    @Before("execution(String com.example.demo.app.controller.*.*Controller.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("開始ログ：{}", joinPoint.getSignature());
    }

    @After("execution(String com.example.demo.app.controller.*.*Controller.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("終了ログ：{}", joinPoint.getSignature());
    }
}