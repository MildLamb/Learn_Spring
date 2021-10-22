import com.mildlamb.dao.Impl.MysqlUserDaoImpl;
import com.mildlamb.dao.Impl.UserDaoImpl;
import com.mildlamb.pojo.Hello;
import com.mildlamb.service.Impl.UserServiceImpl;
import com.mildlamb.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        UserService userService = new UserServiceImpl(new UserDaoImpl());
        userService.getUser();
    }

    @Test
    public void test_spring(){
        //获取spring的上下文对象 (spring容器)
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
        //需要什么bean就获取什么bean
        UserService userService = ac.getBean("userService",UserService.class);
        userService.getUser();
    }

    @Test
    public void test_spring2(){
        //获取spring的上下文对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
        Hello hello = ac.getBean("hello",Hello.class);
        System.out.println(hello);
    }
}
