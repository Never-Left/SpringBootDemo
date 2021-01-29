package com.dong.commons.utils;

import java.sql.*;

/**
 * Created by fengxk on 2018/11/15.
 */
public class JDBCUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    // private static String
    // url="jdbc:mysql://47.93.114.22:8904/andsdk?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf-8";
    // private static String user="bdc";
    // private static String password="BDCyingxiogSdk2018";

    private JDBCUtils() {
    }

    static {
        /**
         * 驱动注册
         */
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取 Connetion
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    /**
     * 释放连接 Connection
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 等待垃圾回收
        conn = null;
    }

    /**
     * 释放语句执行者 Statement
     *
     * @param st
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 等待垃圾回收
        st = null;
    }

    /**
     * 释放结果集 ResultSet
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 等待垃圾回收
        rs = null;
    }
}
