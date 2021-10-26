import com.mildlamb.mapper.UserMapper;
import com.mildlamb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.queryUsers();
        for(User user : users){
            System.out.println(user);
        }
    }
}
