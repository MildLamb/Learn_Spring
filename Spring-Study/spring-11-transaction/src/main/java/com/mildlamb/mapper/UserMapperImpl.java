package com.mildlamb.mapper;

import com.mildlamb.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public List<User> queryUsers() {
        User user = new User(6,"珏","123234");
        addUser(user);
        delUser(5);
        return getSqlSession().getMapper(UserMapper.class).queryUsers();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int delUser(Integer id) {
        return getSqlSession().getMapper(UserMapper.class).delUser(id);
    }
}
