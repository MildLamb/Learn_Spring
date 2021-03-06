package com.mildlamb.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我们需要用这个类 自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //需要实现的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        seeHouse();
        //动态代理的本质，就是使用反射机制
        Object result = method.invoke(rent, args);

        return result;
    }

    public void seeHouse(){
        System.out.println("带你看看房子");
    }
}
