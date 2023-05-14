package com.aic.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            //读取 jdbc.properties 属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //    获取数据库连接池中的连接
    public static Connection getConnection(){
        Connection con = conns.get();

        if (con == null){
            try {
                con = dataSource.getConnection();
                conns.set(con); // 保存到 ThreadLocal 中，供后面的 jdbc 操作使用
                con.setAutoCommit(false);// 设置为手动管理事务

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return con;
    }

    //    提交事务，关闭连接
    public static void commitAndClose(){
        Connection con = conns.get();
        if(con != null){
            try {
                con.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        conns.remove(); // 不执行 remove 操作将会报错（Tomcat 服务器底层使用了线程池技术）
    }

    // 事务回滚，连接释放
    public static void rollbackAndClose(){
        Connection con = conns.get();
        if(con != null){
            try {
                con.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        conns.remove(); // 不执行 remove 操作将会报错（Tomcat 服务器底层使用了线程池技术）
    }

}
