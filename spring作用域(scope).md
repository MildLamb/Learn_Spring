# spring作用域
- 单例模式(singleton):无论调用几次bean都是同一个对象
```xml
<bean id="user" class="com.mildlamb.pojo.User" scope="singleton">
    <property name="name" value="gnar"></property>
    <property name="age" value="9"></property>
</bean>
```
- 原型模式(prototype):每次从容器中获取bean都会创建一个新的对象
```xml
<bean id="user" class="com.mildlamb.pojo.User" scope="prototype">
    <property name="name" value="gnar"></property>
    <property name="age" value="9"></property>
</bean>
```
- request
- session
- application
