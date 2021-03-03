//package com.dong.commons.utils;
//
//import java.lang.reflect.Field;
//import java.sql.*;
//import java.util.*;
//
///**
// * @ClassName JDBCManager
// * @Author jingjing.meng
// * @Date 2018/12/6 16:44
// * @Version 1.0
// **/
//@SuppressWarnings({"all"})
//public class JDBCManager {
//    /**
//     * 完成对数据库标的增加删除和修改的操作
//     *
//     * @param sql
//     * @param params
//     * @return
//     * @throws SQLException
//     */
//    public static boolean updateByPreparedStatement(String sql, List<Object> params) {
//        boolean flag = false;
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        try {
//            connection = JdbcUtil.getConnection();
//            int result = -1;// 表示当用户执行增加删除和修改的操作影响的行数
//            int index = 1; // 表示 占位符 ，从1开始
//            pstmt = connection.prepareStatement(sql);
//            if (params != null && !params.isEmpty()) {
//                for (int i = 0; i < params.size(); i++) {
//                    pstmt.setObject(index++, params.get(i)); // 填充占位符
//                }
//            }
//            result = pstmt.executeUpdate();
//            flag = result > 0 ? true : false;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtil.close(connection, pstmt);
//        }
//        return flag;
//    }
//
//    /**
//     * 查询返回多条记录
//     *
//     * @param sql
//     * @param params
//     * @return
//     * @throws SQLException
//     */
//    public static List<Map<String, Object>> findMoreResult(String sql, List<Object> params) {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        ResultSet resultSet = null;
//        try {
//            connection = JdbcUtil.getConnection();
//            pstmt = connection.prepareStatement(sql);
//            int index = 1; // 表示占位符
//            if (params != null && !params.isEmpty()) {
//                for (int i = 0; i < params.size(); i++) {
//                    pstmt.setObject(index++, params.get(i));
//                }
//            }
//            resultSet = pstmt.executeQuery(); // 返回查询结果集合
//            ResultSetMetaData metaData = resultSet.getMetaData(); // 获得列的结果
//
//            while (resultSet.next()) {
//                Map<String, Object> map = new HashMap<String, Object>();
//                int cols_len = metaData.getColumnCount(); // 获取总的列数
//                for (int i = 0; i < cols_len; i++) {
//                    String col_name = metaData.getColumnName(i + 1); // 获取第 i列的字段名称
//                    // ,列计算从1开始
//                    Object col_value = resultSet.getObject(col_name); // 获取第i列的内容值
//                    if (col_value == null) {
//                        col_value = "";
//                    }
//
//                    map.put(col_name, col_value);
//                }
//                list.add(map);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtil.closeAll(connection, pstmt, resultSet);
//        }
//        return list;
//
//    }
//
//    /**
//     * 查询返回多个JavaBean(通过java反射机制)
//     *
//     * @param sql
//     * @param params
//     * @param cls
//     * @return
//     * @throws Exception
//     */
//    public static <T> List<T> findMoreRefResult(String sql, List<Object> params, Class<T> cls) {
//        List<T> list = new ArrayList<T>();
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        ResultSet resultSet = null;
//        try {
//            connection = JdbcUtil.getConnection();
//            int index = 1; //占位符
//            pstmt = connection.prepareStatement(sql);
//            if (params != null && !params.isEmpty()) {
//                for (int i = 0; i < params.size(); i++) {
//                    pstmt.setObject(index++, params.get(i));
//                }
//            }
//            resultSet = pstmt.executeQuery(); // 返回查询结果集合
//
//            ResultSetMetaData metaData = resultSet.getMetaData(); // 返回列的信息
//            int cols_len = metaData.getColumnCount(); // 结果集中总的列数
//            while (resultSet.next()) {
//                // 通过反射机制创建一个java实例
//                T resultObject = cls.newInstance();
//                for (int i = 0; i < cols_len; i++) {
//                    String col_name = metaData.getColumnName(i + 1); // 获得第i列的名称
//                    Object col_value = resultSet.getObject(col_name); // 获得第i列的内容
////                    if (col_value == null) {
////                        col_value = "";
////                    }
//                    Field field = cls.getDeclaredField(col_name);
//                    field.setAccessible(true); // 打开JavaBean的访问private权限
//                    field.set(resultObject, col_value);
//                }
//                list.add(resultObject);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtil.closeAll(connection, pstmt, resultSet);
//        }
//        return list;
//    }
//
//    public static int updateByPreparedStatementReturnInt(String sql, List<Object> params) {
//        Connection connection = null;
//        PreparedStatement pstmt = null;
//        int result = -1;// 表示当用户执行增加删除和修改的操作影响的行数
//        try {
//            connection = JdbcUtil.getConnection();
//            int index = 1; // 表示 占位符 ，从1开始
//            pstmt = connection.prepareStatement(sql);
//            if (params != null && !params.isEmpty()) {
//                for (int i = 0; i < params.size(); i++) {
//                    pstmt.setObject(index++, params.get(i)); // 填充占位符
//                }
//            }
//            result = pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtil.close(connection, pstmt);
//        }
//        return result;
//    }
//}
