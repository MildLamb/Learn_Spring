## IOC理论推导
- 原来实现业务的流程
  - XxxDao接口
  - XxxDaoImpl实现类
  - XxxService业务接口
  - XxxServiceImpl业务实现类

```java
public class UserServiceImpl implements UserService {

    private UserDao userDao = new MysqlUserDaoImpl();

    public void getUser() {
        userDao.getUser();
    }
}
```
```java
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
```
```bash
对比两种实现方式
前者：程序主动创建对象，控制权在程序员手上
后者：使用set注入后，程序不再拥有主动性，而是变成了被动的接收对象
这就是控制反转的原型
```

### IOC本质
控制反转(Inversion of Control),是一种设计思想,DI(依赖注入)是实现IOC的一种方式。  
没有IOC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，  
对象的创建由程序自己控制，控制反转后对象的创建交给了第三方。  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--
        没有IOC：
            类型 变量名 = new 类型();
          Hello hello = new Hello();

          SpringBean:
            id = 变量名
           class = new 的对象
         properties = 给对象的属性设置一个值
    -->

    <bean id="hello" class="com.mildlamb.pojo.Hello">
        <property name="str" value="HelloSpring"></property>
    </bean>

    <!-- 改造 -->
    <bean id="userDaoImpl" class="com.mildlamb.dao.Impl.UserDaoImpl"></bean>
    <bean id="mysqlDaoImpl" class="com.mildlamb.dao.Impl.MysqlUserDaoImpl"></bean>

    <!-- ref:引用spring中创建好的对象
        value：具体的值，基本数据类型
     -->
    <bean id="userService" class="com.mildlamb.service.Impl.UserServiceImpl">
        <property name="userDao" ref="mysqlDaoImpl"></property>
    </bean>

</beans>
```
要实现不同的操作，只需要在xml配置文件中进行修改，我们不需要再到程序中进行改动了，对象由Spring创建，管理，装配。

### IOC创建对象的方式
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="user" class="com.mildlamb.pojo.User">
        <!-- set方法注入 -->
<!--        <property name="name" value="千珏"></property>-->
      
      <!-- ============================================== -->

        <!-- 构造器注入 -->
<!--        <constructor-arg index="0" value="永猎双子"></constructor-arg>-->

        <constructor-arg name="name" value="镜爪"></constructor-arg>
    </bean>
  
      <!-- ============================================== -->

    <!-- 实例工厂方法创建对象 -->
    <bean id="user2" class="com.mildlamb.pojo.User2">
        <property name="user" ref="myNeedFactory"></property>
    </bean>

    <!-- 实际生产对象的工厂 -->
    <bean id="userFactory" class="com.mildlamb.factory.UserFactory"></bean>
    <!-- 我需要的工厂的信息，也就是上面的工厂  factory-bean：这个工厂是谁  factory-method：生产对象的方法是哪一个 -->
    <bean id="myNeedFactory" factory-bean="userFactory" factory-method="getUser"></bean>

      <!-- ============================================== -->

    <!-- 静态工厂方法创建对象 -->
    <bean id="user2" class="com.mildlamb.pojo.User2">
        <property name="user" ref="myNeedFactory"></property>
    </bean>

    <!-- 我需要的工厂的信息，也就是上面的工厂  class：这个静态工厂是谁  factory-method：生产对象的方法是哪一个 -->
    <bean id="myNeedFactory" class="com.mildlamb.factory.UserFactory2" factory-method="getUser"></bean>
</beans>
```
