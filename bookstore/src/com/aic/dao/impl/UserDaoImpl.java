package com.aic.dao.impl;


import com.aic.dao.UserDao;
import com.aic.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserBuUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserBuUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username , password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUserId(Integer userId) {
        String sql = "select * from t_user where id = ?";
        return queryForOne(User.class,sql,userId);
    }
}
