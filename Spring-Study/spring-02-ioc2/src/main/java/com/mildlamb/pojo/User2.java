package com.mildlamb.pojo;

public class User2 {
    private User user;

    public User2() {
    }

    public User2(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User2{" +
                "user=" + user +
                '}';
    }
}
