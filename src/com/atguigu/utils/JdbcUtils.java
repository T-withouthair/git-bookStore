package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 编写 工具类 JdbcUtils
 */

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    //初始化（使用 静态代码 更快）
    static {
        try {
            Properties properties = new Properties();//读取属性信息
            //读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);//需要一个流（这个流是读取jdbc文件得到的）
            //创建 数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            //测试数据库连接池是否创建成功 --> 通过main方法
//            System.out.println( dataSource.getConnection() );

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Ctrl + Alt + T --> try/catch（捕获异常）
        //Alt + Enter --> 类型转换
    }

    /* public static void main(String[] args) {

    } */

    /**
     * 获取数据库连接池中的连接
     * 如果返回null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){

        // 确保所有操作使用同一个Connection连接对象
        Connection conn = conns.get();

        if (conn == null) {
            // 若连接池为空，就从连接池里面取
            try {
                conn = dataSource.getConnection();
                // 保存到ThreadLocal对象中，供后面的jdbc操作使用
                conns.set(conn);
                // 设置为手动管理事务
                conn.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose() {
        // 从Connection里获取连接
        Connection connection = conns.get();

        // 如果不等于null，说明 之前使用过连接，操作过数据库
        if (connection != null) {
            try {
                //提交事务
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接，释放资源
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错。(因为Tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose() {
        // 从Connection里获取连接
        Connection connection = conns.get();

        // 如果不等于null，说明 之前使用过连接，操作过数据库
        if (connection != null) {
            try {
                // 回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接，释放资源
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错。(因为Tomcat服务器底层使用了线程池技术)
        conns.remove();
    }
}

       /* Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;*/


//    /**
//     *关闭连接，放回数据库连接池
//     */
//    public static void close(Connection conn){
//        //先判断连接不等于空（空指针异常）--> 捕获异常
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
