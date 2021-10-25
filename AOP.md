# AOP
### 什么是AOP?
AOP(Aspect Oriented Programming，面向切面编程),通过预编译方式和运行期间动态代理实现程序功能  
的统一维护的一种技术。AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是  
函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各个部分之间的耦  
合度降低，提高程序的可重用性，同时提高了开发的效率。
<hr>

### Aop在Spring中的作用
提供声明式事务;允许用户自定义切面
- 横切关注点：跨越应用程序多个模块的方法或功能。即是，与我们业务逻辑无关的，但是我们需要关注的部分，  
就是横切关注点。如日志，安全，缓存，事务等等...
- 切面(Aspect):横切关注点 被模块化的特殊对象，它是一个类
- 通知(Advice):切面需要完成的工作，它是类中的方法
- 目标(Target):被通知的对象
- 代理(Proxy):向目标对象应用通知后创建的对象
- 切入点(PointCut):切面通知 执行的"地点"的定义
- 连接点(JointPoint):与切入点匹配的执行点

<hr>


### 使用Spring实现AOP
- 使用AOP织入，需要导入一个依赖包
```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.6</version>
</dependency>
```
方式一: 使用spring的API接口  
- 业务类
```java
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("add one user");
    }

    public void update() {
        System.out.println("update a user");
    }

    public void del() {
        System.out.println("del one user");
    }

    public void select() {
        System.out.println("select all users");
    }
}
```
- 通知类(横切关注点),分别实现对应的接口
```java
public class BeforeLog implements MethodBeforeAdvice {
    /*
    * method: 要执行的目标对象方法
    * args: 参数
    * o: 目标对象
    * */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "方法被执行了");
    }
}
```
```java
public class AfterLog implements AfterReturningAdvice {
    //returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(method.getClass().getName() + "执行完了,结果为:" + returnValue);
    }
}
```
- application.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 注册bean -->
    <bean id="userService" class="com.mildlamb.service.impl.UserServiceImpl"></bean>
    <bean id="before_log" class="com.mildlamb.log.BeforeLog"></bean>
    <bean id="after_log" class="com.mildlamb.log.AfterLog"></bean>

    <!-- 配置aop:需要导入aop的约束 -->
    <aop:config>
        <!-- 切入点  expression:表达式 execution(要执行的位置) 修饰符 返回值 包名.类名.方法名(参数列表)-->
        <aop:pointcut id="pointcut" expression="execution(* com.mildlamb.service.*.*(..))"/>

        <!-- 执行环绕增加 -->
        <aop:advisor advice-ref="after_log" pointcut-ref="pointcut"></aop:advisor>
        <aop:advisor advice-ref="before_log" pointcut-ref="pointcut"></aop:advisor>

    </aop:config>

    <!-- 开启spring aop的支持 -->
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
</beans>
```
- 测试类
```java
@Test
public void test(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application.xml");
    UserService userService = ac.getBean("userService", UserService.class);
    userService.add();
}
```
