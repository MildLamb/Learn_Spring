package com.mildlamb.pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

public class User {
    @Nullable
    private String name;
//    @Autowired(required = false)
//    @Qualifier("dog123")
    @Resource(name = "dog123")
    private Dog dog;
    @Autowired
    private Cat cat;

    public User() {
    }

    public User(Dog dog, Cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public User(String name, Dog dog, Cat cat) {
        this.name = name;
        this.dog = dog;
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public Dog getDog() {
        return dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
