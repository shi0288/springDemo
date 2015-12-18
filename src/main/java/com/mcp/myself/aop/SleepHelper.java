package com.mcp.myself.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/12/15 0015.
 */

@Aspect
public class SleepHelper {


    @Pointcut("execution(* com.mcp.myself.service.PersonServiceBean.*(..))")
    private void anyMethod(){}//定义一个切入点

    @AfterReturning("anyMethod()")
    public void ddd(){
        System.out.println("吃完饭了，睡觉");
    }

}
