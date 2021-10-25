package com.mildlamb.proxy2.impl;

import com.mildlamb.proxy2.UserService;

//真实对象
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("add one user");
    }

    public void update() {
        System.out.println("update user");
    }

    public void del() {
        System.out.println("del one user");
    }

    public void select() {
        System.out.println("select all users");
    }
}
