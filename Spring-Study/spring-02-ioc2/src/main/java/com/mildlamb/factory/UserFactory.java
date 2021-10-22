package com.mildlamb.factory;

import com.mildlamb.pojo.User;

public class UserFactory {
    public User getUser(){
        return new User("纳尔");
    }
}
