package com.dong.springboot.service;

import com.dong.springboot.bean.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangDong
 * Date: 2019/7/29 15:31
 */
public interface UserService {

    /**
     * 根据名字查找用户
     */
    public User selectUserByName(String name);

    /**
     * 查找所有用户
     */
    public List<User> selectAllUser();

    /**
     * 插入两个用户
     */
    public void insertService();

    /**
     * 根据id 删除用户
     */

    public void deleteService(int id);

    /**
     * 转账
     */
    public void changemoney();

}
