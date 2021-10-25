package com.mildlamb.diy;

//切面
public class DiyAspect {

    public void before_Method(){
        System.out.println("=============方法执行前=============");
    }

    public void after_Method(){
        System.out.println("=============方法执行后=============");
    }
}
