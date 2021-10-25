package com.mildlamb.proxy2;

import com.mildlamb.proxy2.impl.UserServiceImpl;
import com.mildlamb.proxy2.impl.UserServiceProxy;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserServiceProxy userService = new UserServiceProxy();
        userService.setUserService(userServiceImpl);
        userService.add();
    }
}
