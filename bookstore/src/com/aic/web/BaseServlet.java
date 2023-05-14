package com.aic.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//从 UserServlet 和 BookServlet 中提取的公共部分，用于获取请求的 action 和调用对应方法处理请求
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        解决响应中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        //利用反射处理对应的客户需求，优化 if else 判断
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e); // 把异常抛给 Filter 过滤器
        }
    }
}
