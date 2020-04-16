package com.stx.epcs.util;

import java.sql.*;

/**
 * Created by Administrator on 2020/3/26 0026.
 */
public class JdbcUtil {

    /**
     * 获取一下连接
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            //1.加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.建立连接
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl",
                    "Iris", "Xcy19990327");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //运行时异常不用捕获
            throw new RuntimeException(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            //运行时异常不用捕获
            throw new RuntimeException(e.getMessage());
        }
        //没有连接成功返回null
        //return null;
    }

    /**
     * 关闭连接
     *
     * @param con 数据库连接
     * @param st  Statement
     */
    public static void closeConnection(Connection con, Statement st) {
        try {
            //先开后关
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 关闭连接
     *
     * @param con
     * @param st
     * @param rs
     */
    public static void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            //先开后关
            if (rs != null) {
                rs.close();
            }
            //调用前面的函数关闭con 和st
            closeConnection(con, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * 增删改 (封装)
     * @param sql
     * @return
     */
    public static int executeUpdate(String sql) {
        Connection conn = null;
        Statement st = null;
        try {
            //获取连接
            conn = getConnection();
            //获取 Statement
            st = conn.createStatement();
            // 执行操作
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        } finally {
            JdbcUtil.closeConnection(conn, st);
        }
    }

}
