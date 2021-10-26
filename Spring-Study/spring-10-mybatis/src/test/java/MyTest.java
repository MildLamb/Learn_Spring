import com.mildlamb.mapper.UserMapper;
import com.mildlamb.mapper.UserMapperImpl;
import com.mildlamb.mapper.UserMapperImpl2;
import com.mildlamb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapperImpl userMapperImpl = ac.getBean("userMapperImpl", UserMapperImpl.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionTemplate sqlSession = ac.getBean("sqlSession", SqlSessionTemplate.class);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapperImpl = ac.getBean("userMapperImpl2", UserMapperImpl2.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
