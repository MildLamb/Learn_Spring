package com.mildlamb.mapper;

import com.mildlamb.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    //我们的所有操作以前用sqlSession执行，现在用sqlSessionTemplate执行
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> selectUsers() {
        return sqlSessionTemplate.getMapper(UserMapper.class).selectUsers();
    }
}
