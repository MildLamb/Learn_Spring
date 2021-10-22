# 依赖注入
### 构造器注入
```xml
<bean id="user" class="com.mildlamb.pojo.User">

        <!-- 构造器注入 -->
<!--        <constructor-arg index="0" value="永猎双子"></constructor-arg>-->

        <constructor-arg name="name" value="镜爪"></constructor-arg>
    </bean>
```

### Set方式注入
- 测试要注入的对象
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    private String name;
    private Address address;
    private String[] skills;
    private List<String> hobbies;
    private Map<String,String> alias;
    private Set<String> achievement;
    private Properties info;
    private String wife;
}
```
- bean的注入,applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="area" class="com.mildlamb.pojo.Address">
        <property name="address" value="符文大陆"></property>
    </bean>

    <bean id="champion" class="com.mildlamb.pojo.Champion">
        <!-- 普通值注入,直接用value -->
        <property name="name" value="kindred"></property>

        <!-- 第二种，bean注入使用ref -->
        <property name="address" ref="area"></property>

        <!-- 第三种，数组注入使用array -->
        <property name="alias">
            <array>
                <value>永猎双子</value>
                <value>镜爪</value>
            </array>
        </property>

        <!-- 第四种，list注入使用list -->
        <property name="hobbies">
            <list>
                <value>捉迷藏</value>
                <value>狩猎</value>
                <ref bean="area"></ref>
            </list>
        </property>

        <!-- 第五种，map集合使用map -->
        <property name="skills">
            <map>
                <entry key="P" value="千珏之印"></entry>
                <entry key="Q" value="乱箭之舞"></entry>
                <entry key="W" value="狼灵狂热"></entry>
                <entry key="E" value="横生俱意"></entry>
                <entry key="R" value="羊灵生息"></entry>
            </map>
        </property>

        <!-- 第六种，set集合注入使用set -->
        <property name="achievement">
            <set>
                <value>标记大师</value>
                <value>狼灵灾祸</value>
                <value>闪耀救场</value>
            </set>
        </property>

        <!-- 第七种，空值/null注入 -->
        <!-- 空值 -->
<!--        <property name="wife" value=""></property>-->
        <!-- null -->
        <property name="wife">
            <null></null>
        </property>

        <!-- 第八种，配置项注入props -->
        <property name="info">
            <props>
                <prop key="id">127</prop>
                <prop key="location">jup</prop>
            </props>
        </property>
    </bean>
</beans>
```

### c命名空间(对应construct-arg构造器注入)和p命名空间(对应properties的set注入)注入
- 导入p命名空间约束 xmlns:p="http://www.springframework.org/schema/p"
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- p命名空间注入
        可以直接注入属性的值
     -->
    <bean id="user" class="com.mildlamb.pojo.User" p:name="QSJ" p:age="24"></bean>
        
        <!-- c命名空间注入
        通过构造器进行注入
     -->
    <bean id="user2" class="com.mildlamb.pojo.User" c:age="24" c:name="qsj"></bean>

</beans>
```
