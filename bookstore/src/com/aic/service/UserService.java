package com.aic.service;


import com.aic.pojo.User;

public interface UserService {

    /**
     * 注册用户账号
     * @param user  所注册账号
     * @return  true 注册成功，否则失败
     */
    public boolean registerUser(User user);

    /**
     * 根据账号检查账号是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);
}
