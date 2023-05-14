package com.aic.service.impl;

import com.aic.dao.UserDao;
import com.aic.dao.impl.UserDaoImpl;
import com.aic.pojo.User;
import com.aic.service.UserService;



public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean registerUser(User user) {
        if(existsUsername(user.getUsername())) return false;
        userDao.saveUser(user);
        return true;
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserBuUsername(username) != null) return true;
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.queryUserBuUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
