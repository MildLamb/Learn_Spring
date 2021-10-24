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
