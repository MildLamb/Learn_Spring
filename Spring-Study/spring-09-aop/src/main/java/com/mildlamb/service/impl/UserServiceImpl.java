package com.mildlamb.service.impl;

import com.mildlamb.service.UserService;

public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("add one user");
    }

    public void update() {
        System.out.println("update a user");
    }

    public void del() {
        System.out.println("del one user");
    }

    public void select() {
        System.out.println("select all users");
    }
}
