package com.mildlamb.config;

import com.mildlamb.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//配置类
@Configuration
@ComponentScan("com.mildlamb")
@Import(MySpringConfig2.class)
public class MySpringConfig {

    //注册一个bean，相当于<bean>
    //方法的名字，相当于bean的id属性
    //方法的返回值，相当于bean的class属性
    @Bean(value = "EngulfMissing")
    public User getUser(){
        return new User();
    }

    @Bean("wolf")
    public User getUser2(){
        return new User("Kindred");
    }
}
