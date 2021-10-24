import com.mildlamb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = ac.getBean("user", User.class);
        User user2 = ac.getBean("user", User.class);
        System.out.println(user == user2);
    }
}
