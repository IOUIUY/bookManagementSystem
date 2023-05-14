// 事务过滤器，当数据库操作未完全完成时不保存之前操作
package com.aic.filter;


import com.aic.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        }catch (Exception e){
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e); // 向 Tomcat 抛出异常，展示错误页面
        }
    }

    @Override
    public void destroy() {

    }
}
