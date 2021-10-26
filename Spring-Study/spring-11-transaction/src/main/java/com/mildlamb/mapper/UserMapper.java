package com.mildlamb.mapper;

import com.mildlamb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> queryUsers();

    //添加一个用户
    int addUser(User user);

    //删除一个用户
    int delUser(@Param("id") Integer id);
}
