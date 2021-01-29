package com.dong.commons.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.*;
import java.util.Properties;

@SuppressWarnings({"all"})
public class JdbcUtil {
    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(JdbcUtil.class);
    private static DruidDataSource dataSource;

    static {
        java.io.InputStream in = JdbcUtil.class.getResourceAsStream("/config.properties");
        try {
            Properties p = new Properties();
            p.load(in);
            Properties pro = new Properties();
            pro.setProperty("driver", p.getProperty("datasources.driverClassName"));
            pro.setProperty("url", p.getProperty("datasources.url"));
            pro.setProperty("username", p.getProperty("datasources.username"));
            pro.setProperty("password", p.getProperty("datasources.password"));
            pro.setProperty("initialSize", p.getProperty("datasources.initialSize"));
            pro.setProperty("maxActive", p.getProperty("datasources.maxActive"));
            pro.setProperty("minIdle", p.getProperty("datasources.minIdle"));
            pro.setProperty("maxWait", p.getProperty("datasources.maxWait"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据源链接
     *
     * @param datasource
     * @return
     */
    public static Connection getConnection() {
        try {
            if (dataSource != null) {
                return dataSource.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     *
     * @Author CCG
     * @Date 2018/12/6 16:18
     * @Param [connection, statement]
     **/
    public static void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     *
     * @Author CCG
     * @Date 2018/12/6 16:18
     * @Param [connection, statement]
     **/
    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 释放资源
     **/
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取insert SQL
     **/
    public static String getReplacePreSql(String col, String taleName) {
        String remark = getunknowRemark(col);
        StringBuffer sql = new StringBuffer();
        sql.append("REPLACE ");
        sql.append(" INTO ");
        sql.append(taleName);
        sql.append(" (");
        sql.append(col);
        sql.append(" )  VALUES (");
        sql.append(remark);
        sql.append(" )");
        return sql.toString();
    }

    /**
     * 获取insert SQL
     *
     * @Author CCG
     * @Date 2018/12/17 11:20
     * @Param [col, taleName, isIgnore]
     **/
    public static String getInsertPreSql(String col, String taleName, boolean isIgnore) {
        String remark = getunknowRemark(col);
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT ");
        if (isIgnore) {
            sql.append("ignore");
        }
        sql.append(" INTO ");
        sql.append(taleName);
        sql.append(" (");
        sql.append(col);
        sql.append(" )  VALUES (");
        sql.append(remark);
        sql.append(" )");
        return sql.toString();
    }

    public static String getInsertPreSqlByAppkey(String col, String taleName, boolean isIgnore, String appkey) {
        String remark = getunknowRemark(col);
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT ");
        if (isIgnore) {
            sql.append("ignore");
        }
        sql.append(" INTO ");
        if ("1aa9c860218b4e739af1e0fcc7c5a533".equals(appkey)) {
            sql.append("game_info1008.");
        }
        sql.append(taleName);
        sql.append(" (");
        sql.append(col);
        sql.append(" )  VALUES (");
        sql.append(remark);
        sql.append(" )");
        return sql.toString();
    }

    public static String getunknowRemark(String col) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < col.split(",").length; i++) {
            sb.append("?").append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
