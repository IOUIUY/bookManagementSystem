package com.aic.web;

import com.aic.pojo.User;
import com.aic.service.UserService;
import com.aic.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录请求
 */
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    /**
     * 处理登录
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(new User(null, username, password, null));
        System.out.println("fdjsl");
        //没有在数据库中找到匹配账号
        if(user == null){
            if(!username.equals("")) req.setAttribute("msg","用户或密码错误！");
            else req.setAttribute("msg" , "请输入账号和密码！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
        }else{
            // 登录成功
            // 保存登录信息
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/bookstoreManagement.jsp").forward(req,resp);
        }
    }
}
