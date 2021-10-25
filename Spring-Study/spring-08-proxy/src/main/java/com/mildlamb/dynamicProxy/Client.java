package com.mildlamb.dynamicProxy;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色:动态生成
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过InvocationHandler来处理我们要调用的接口对象
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxyInstance();
        proxy.rent();
    }
}
