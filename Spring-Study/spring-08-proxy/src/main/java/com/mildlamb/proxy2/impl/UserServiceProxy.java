package com.mildlamb.proxy2.impl;

import com.mildlamb.proxy2.UserService;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log();
        userService.add();
    }

    public void update() {
        log();
        userService.update();
    }

    public void del() {
        log();
        userService.del();
    }

    public void select() {
        log();
        userService.select();
    }

    private void log(){
        System.out.println("打印日志");
    }
}
