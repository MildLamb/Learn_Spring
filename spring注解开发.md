# spring注解开发

applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 指定要扫描的包，这个包下的注解就会生效 -->
    <context:component-scan base-package="com.mildlamb"></context:component-scan>
    <!-- 开启spring注解支持 -->
    <context:annotation-config></context:annotation-config>

</beans>
```

- bean
- 属性如何注入
- 衍生的注解
```bash
@Component有几个衍生注解，由于为了更好的区分webmvc三层架构
 * dao - @Repository
 * service - @Service
 * controller - @Controller
```
- 自动装配置
- 作用域


User
```java
//等价于<bean>
@Component(value = "beanid")
@Scope("singleton")
public class User {
    @Value("千珏珏珏子")
    //等价于<properties name="name" value="千珏珏珏子">
    private String name;

    public String getName() {
        return name;
    }
}
```
- 小结
xml与注解：  
  - xml更加万能，适用于任何场合，维护简单方便
  - 注解维护相对复杂

实际开发中：  
  - bean由xml来管理
  - 属性由注解注入

注意点：  
想让注解生效，就要开启注解支持
```xml
    <!-- 指定要扫描的包，这个包下的注解就会生效 -->
    <context:component-scan base-package="com.mildlamb"></context:component-scan>
    <!-- 开启spring注解支持 -->
    <context:annotation-config></context:annotation-config>
```

## 完全注解开发,使用java的方式配置spring
我们将不使用spring的xml配置了，全权交给java来做  
javaConfig是spring的一个子项目，在spring4之后，成为了一个核心功能  
```bash
@Configuration: 标注为配置类
@Bean: 将方法的返回值注册到spring容器中
AnnotationConfigApplicationContext: 使用java配置类方式，将使用该实现类获取ioc容器
```
- pojo类
```java
@Component
public class User {
    @Value("Gnar")
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```
- 配置类
```java
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
}
```
- 测试
```java
@Test
    public void test(){
        //如果完全使用配置类方式实现spring，我们就要通过AnnotationConfigApplicationContext容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(MySpringConfig.class);
        User user = ac.getBean("EngulfMissing", User.class);
        System.out.println(user.getName());
    }
```

