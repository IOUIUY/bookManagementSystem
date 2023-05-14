package com.aic.dao;


import com.aic.pojo.User;

public interface UserDao {
    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    public User queryUserBuUsername(String username);

    /**
     * 通过用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User queryUserBuUsernameAndPassword(String username , String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    public User queryUserByUserId(Integer userId);
}
