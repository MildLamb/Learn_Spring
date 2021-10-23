# 自动装配
### byName
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat" class="com.mildlamb.pojo.Cat"></bean>
    <bean id="dog" class="com.mildlamb.pojo.Dog"></bean>
  
    <!--
      byName:会在容器上下文中自动查找，和自己对象set的属性对应的beanid
      set的属性指的是setter方法去掉set后首字母小写
    -->
    <bean id="user" class="com.mildlamb.pojo.User" autowire="byName">
        <property name="name" value="QSJ"></property>
    </bean>

</beans>
```

### byType
不能存在多个相同类型的bean
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="OneCat" class="com.mildlamb.pojo.Cat"></bean>
    <bean id="TwoDog" class="com.mildlamb.pojo.Dog"></bean>
    <!--
      byType:会在容器上下文中自动查找，和自己对象属性类型相同的bean进行注入
    -->
    <bean id="user" class="com.mildlamb.pojo.User" autowire="byType">
        <property name="name" value="QSJ"></property>
    </bean>

</beans>
```

### constructor
注意：使用constructor，spring并不会结合手动装配好的属性，例如下面的情况，就要求User类提供带Cat和Dog的构造器
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="OneCat" class="com.mildlamb.pojo.Cat"></bean>
    <bean id="TwoDog" class="com.mildlamb.pojo.Dog"></bean>
    <!--
      byName:会在容器上下文中自动查找，和自己对象set的属性对应的beanid
      set的属性指的是setter方法去掉set后首字母小写
    -->
    <bean id="user" class="com.mildlamb.pojo.User" autowire="constructor">
        <property name="name" value="QSJ"></property>
    </bean>

</beans>
```

## 使用注解实现自动装配
要使用注解需要一些额外的约束
- 导入约束
- 开启注解支持<context:annotation-config></context:annotation-config>
- pojo类中选择需要注入的属性添加@Autowired注解

**实体类**  
@Autowired默认按照类型注入  
required属性表示该属性是否一定需要注入，false表示允许不注入该属性  
@Qualifier：当注入的bean类型存在多个，通过@Qualifier指定明确的beanid  
```java
public class User {
    private String name;
    @Autowired(required = false)
    @Qualifier("dog123")
    private Dog dog;
    @Autowired
    private Cat cat;

    ... ...
```

**applicationContext.xml**  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 开启spring注解支持 -->
    <context:annotation-config></context:annotation-config>

    <bean id="cat123" class="com.mildlamb.pojo.Cat"></bean>
    <bean id="dog123" class="com.mildlamb.pojo.Dog"></bean>

    <bean id="user" class="com.mildlamb.pojo.User"></bean>

</beans>
```
