package com.mildlamb.service.Impl;

import com.mildlamb.dao.Impl.MysqlUserDaoImpl;
import com.mildlamb.dao.Impl.UserDaoImpl;
import com.mildlamb.dao.UserDao;
import com.mildlamb.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
