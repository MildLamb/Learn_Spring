package com.mildlamb.proxy;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        System.out.println("我是中介");
        seeHouse();
        host.rent();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
}
