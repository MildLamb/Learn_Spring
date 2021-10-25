package com.mildlamb.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //标注这个类是一个切面
@Component
public class AnnoAspect {

    @Pointcut("execution(* com.mildlamb.service.impl.*.*(..))")
    private void pt(){}

    @Before("pt()")
    public void method_Before(){
        System.out.println("=========Before=========");
    }

    @AfterReturning("execution(* com.mildlamb.service.impl.*.*(..))")
    public void method_AfterReturning(){
        System.out.println("=========Return=========");
    }

    @Around("execution(* com.mildlamb.service.impl.*.*(..))")
    public void method_Around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");

        System.out.println("signature:" + pjp.getSignature());  //获取签名
        Object proceed = pjp.proceed();  //执行方法

        System.out.println("环绕后");
    }
}
