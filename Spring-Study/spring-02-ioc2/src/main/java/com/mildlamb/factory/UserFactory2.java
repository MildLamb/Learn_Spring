package com.mildlamb.factory;

import com.mildlamb.pojo.User;

public class UserFactory2 {
    public static User getUser(){
        return new User("迷失之牙");
    }
}
