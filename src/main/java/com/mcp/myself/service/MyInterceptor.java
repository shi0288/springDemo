package com.mcp.myself.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ����
 *
 * @author Bird
 */
@Component
@Aspect
public class MyInterceptor {

    @AfterReturning(returning="rtv", value = "execution(* com.mcp.myself.service.PersonServiceBean.*(..))")
    public void doAfter(JoinPoint jp,Object rtv) {
        System.out.println("====================================");

        Signature signature = jp.getSignature();
        System.out.println("DeclaringType:" + signature.getDeclaringType());
        System.out.println("DeclaringTypeName:" + signature.getDeclaringTypeName());
        System.out.println("Modifiers:" + signature.getModifiers());
        System.out.println("Name:" + signature.getName());
        System.out.println("LongString:" + signature.toLongString());
        System.out.println("ShortString:" + signature.toShortString());

        for (int i = 0; i < jp.getArgs().length; i++) {
            Object arg = jp.getArgs()[i];
            if(null != arg) {
                System.out.println("Args:" + arg.toString());
            }
        }

        System.out.println("Return:" + rtv);
        System.out.println("====================================");
    }




}
