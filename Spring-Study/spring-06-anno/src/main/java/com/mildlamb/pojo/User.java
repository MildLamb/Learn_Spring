package com.mildlamb.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于<bean>
@Component(value = "kind")
@Scope("singleton")
public class User {
    @Value("千珏珏珏子")
    private String name;

    public String getName() {
        return name;
    }
}
