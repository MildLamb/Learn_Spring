package com.mildlamb.dynamicProxy2;

import com.mildlamb.proxy2.UserService;
import com.mildlamb.proxy2.impl.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //代理哪个真实角色,将真实角色传入
        pih.setTarget(userService);

        //获取代理对象
        UserService proxyInstance = (UserService) pih.getProxyInstance();
        proxyInstance.add();
    }
}
