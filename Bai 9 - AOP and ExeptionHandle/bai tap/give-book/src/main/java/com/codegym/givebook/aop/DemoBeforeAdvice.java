package com.codegym.givebook.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class DemoBeforeAdvice {
    @After("execution(* com.codegym.givebook.service.BookService.*(..))")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("kết thúc method: " + joinPoint.getSignature().getName());
    }
//
    @AfterThrowing(value = "execution(* com.codegym.givebook.service.BookService.*(..))", throwing = "e")
    public void AfterThrowingCallMethod(JoinPoint joinPoint, Exception e) throws Throwable{
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Hệ Thống] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
//
//    @Pointcut()
//    public void testPointCut(){}


}
