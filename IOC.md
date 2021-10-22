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

