# spring配置
### 别名
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="user" class="com.mildlamb.pojo.User">
        <constructor-arg name="name" value="镜爪"></constructor-arg>
    </bean>
    <!-- 为bean取别名 -->
    <alias name="user" alias="kindred"></alias>
</beans>
```

### bean的配置
```xml
<!--
    id: bean的唯一标识符,也就相当于我们的对象名
    class: bean对象所对应的全限定类名  包名+类名
    name: 也是别名，而且name可以取多个别名
-->
<bean id="userT" class="com.mildlamb.pojo.User"></bean>
```

### import
import一般用于团队开发，它可以将多个配置文件，导入合并为一个
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
  
    <import resource="application.xml"></import>
    <import resource="springConfig.xml"></import>
  
</beans>
```
