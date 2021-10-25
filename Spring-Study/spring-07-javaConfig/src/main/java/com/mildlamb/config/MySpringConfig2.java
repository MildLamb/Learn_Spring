package com.mildlamb.config;

import com.mildlamb.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//配置类
@Configuration
@ComponentScan("com.mildlamb")
public class MySpringConfig2 {

    //注册一个bean，相当于<bean>
    //方法的名字，相当于bean的id属性
    //方法的返回值，相当于bean的class属性
    @Bean(value = "MildLamb")
    public User getUser(){
        return new User("MildLamb");
    }

}
