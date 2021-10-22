import com.mildlamb.pojo.User;
import com.mildlamb.pojo.User2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        User user = new User();
    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = ac.getBean("user", User.class);
        user.show();
    }

    @Test
    public void test2_factory(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application.xml");
        User2 user2 = ac.getBean("user2", User2.class);
        System.out.println(user2.getUser());
    }

    @Test
    public void test_alias(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
        User user = ac.getBean("kindred", User.class);
        user.show();
    }
}
