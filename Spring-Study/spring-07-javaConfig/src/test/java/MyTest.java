import com.mildlamb.config.MySpringConfig;
import com.mildlamb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(MySpringConfig.class);
        User user = ac.getBean("MildLamb", User.class);
        System.out.println(user.getName());
    }
}
