package com.aic.dao.impl;

import com.aic.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用 DbUtils 操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()  用来执行 sql 的 insert、update、delete 语句
     * @return
     */
    public int update(String sql , Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个 JavaBean
     * @param type  返回的对象类型
     * @param sql   执行的 sql 语句
     * @param args  sql 对应的参数值
     * @param <T>   返回的参数类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type , String sql , Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个 javaBean 对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type , String sql , Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回单个值
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql , Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler() , args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
