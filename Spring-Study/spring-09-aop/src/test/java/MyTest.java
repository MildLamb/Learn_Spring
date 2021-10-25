import com.mildlamb.service.UserService;
import com.mildlamb.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        userService.select();
    }
}
