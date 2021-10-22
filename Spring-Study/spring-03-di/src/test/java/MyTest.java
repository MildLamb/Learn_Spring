import com.mildlamb.pojo.Champion;
import com.mildlamb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Champion champion = ac.getBean("champion", Champion.class);
        System.out.println(champion);
    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:userBean.xml");
        //p命名空间测试
//        User user = ac.getBean("user", User.class);
        //c命名空间测试
        User user2 = ac.getBean("user2", User.class);
        System.out.println(user2);
    }
}
