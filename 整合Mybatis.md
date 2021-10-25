# 整合Mybatis
步骤：  
- 导入相关的jar包
  - junit
  - mybatis
  - mysql数据库
  - spring相关的
  - aop织入
  - mybatis-spring

```xml
<!-- junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <!-- mysql数据库 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.48</version>
        </dependency>
        <!-- mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <!-- spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.11</version>
        </dependency>

        <!-- spring操作数据库的话，还需要一个spring-jdbc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.11</version>
        </dependency>
        <!-- AOP -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.6</version>
        </dependency>
        <!-- Mybatis-Spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>
```
- 编写配置文件 mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>

    <typeAliases>
        <package name="com.mildlamb.pojo"/>
    </typeAliases>

    <environments default="mysql">
        <environment id="mysql">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="W2kindred"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper class="com.mildlamb.mapper.UserMapper"></mapper>
    </mappers>
</configuration>
```
- 编写实体类
- 编写mapper接口
- 编写mapper.xml映射文件
```xml
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mildlamb.mapper.UserMapper">
    <select id="selectUsers" resultType="user">
        select * from user
    </select>
</mapper>
```

## Mybatis-Spring
什么是 MyBatis-Spring？  
MyBatis-Spring 会帮助你将 MyBatis 代码无缝地整合到 Spring 中。它将允许MyBatis参与到 Spring 的事务管理之中，  
创建映射器 mapper 和 SqlSession 并注入到 bean 中，以及将 Mybatis 的异常转换为 Spring 的 DataAccessException。   
最终，可以做到应用代码不依赖于 MyBatis，Spring 或 MyBatis-Spring。  

在spring中创建mybatis需要的对象 application.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- DataSource:使用spring的数据源 替换 mybatis的配置
        使用spring提供的JDBC
     -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"></property>
        <property name="username" value="root"></property>
        <property name="password" value="W2kindred"></property>
    </bean>

    <!-- SqlSessionFactory -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <!-- 绑定Mybatis配置文件,绑定以后，你就可以直接通过property来配置核心配置文件了 -->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <property name="typeAliasesPackage" value="com.mildlamb.pojo"></property>
        <property name="mapperLocations" value="classpath:com/mildlamb/mapper/UserMapper.xml"></property>
    </bean>

    <!-- SqlSessionTemplate:就是我们使用的sqlSession -->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <!-- 没有setter方法，只能使用构造器注入 -->
        <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
    </bean>

    <!-- 创建实现类 -->
<!--    <bean id="userMapperImpl" class="com.mildlamb.mapper.UserMapperImpl">-->
<!--        <property name="sqlSessionTemplate" ref="sqlSession"></property>-->
<!--    </bean>-->

</beans>
```
- 实现类方式
```java
public class UserMapperImpl implements UserMapper {

    //我们的所有操作以前用sqlSession执行，现在用sqlSessionTemplate执行
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> selectUsers() {
        return sqlSessionTemplate.getMapper(UserMapper.class).selectUsers();
    }
}
```

- 测试类
```java
@Test
//实现类方式
    public void test() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapperImpl userMapperImpl = ac.getBean("userMapperImpl", UserMapperImpl.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionTemplate sqlSession = ac.getBean("sqlSession", SqlSessionTemplate.class);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
```
