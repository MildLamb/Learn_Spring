package com.mildlamb.dynamicProxy2;

import com.mildlamb.dynamicProxy.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我们需要用这个类 自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object target;
    //设置被代理的接口
    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到代理类
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        otherMethod();
        //动态代理的本质，就是使用反射机制
        Object result = method.invoke(target, args);

        return result;
    }

    public void otherMethod(){
        System.out.println("代理类提供的其他方法");
    }
}
