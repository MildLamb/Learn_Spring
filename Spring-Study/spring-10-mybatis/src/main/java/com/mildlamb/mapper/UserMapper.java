package com.mildlamb.mapper;

import com.mildlamb.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();
}
