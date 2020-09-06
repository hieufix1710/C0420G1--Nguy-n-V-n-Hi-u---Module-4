package com.codegym.pictureofday.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logging {

    public void error (){
        System.out.println("Something wrong here !");
    }
    @AfterThrowing(pointcut = "execution(public * com.codegym.pictureofday.controller.CommentController.*())",throwing = "e")
    public void log(Exception e, JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Project] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));

    }

}
