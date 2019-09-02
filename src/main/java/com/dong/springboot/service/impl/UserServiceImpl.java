package com.dong.springboot.service.impl;

import com.dong.springboot.bean.User;
import com.dong.springboot.dao.UserDao;
import com.dong.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangDong
 * Date: 2019/7/29 15:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 根据名字查找用户
     */
    @Override
    public User selectUserByName(String name) {
//
//
//        if (redisTemplate.opsForValue().get(name) == null) {
//            User user = userDao.findUserByName(name);
//            redisTemplate.opsForValue().set(user.getName(),user);
//            redisTemplate.opsForValue().set("关羽",new User(1002,"关羽",35,3000));
//            return new User(1001,"张飞",30,2000);
//       } else {
//            User user = (User) redisTemplate.opsForValue().get(name);
//
        return null;
//        }
//
//
    }

    /**
     * 查找所有用户
     */
    @Override
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 插入两个用户
     */
    @Override
    public void insertService() {
        userDao.insertUser("SnailClimb", 22, 3000.0);
        userDao.insertUser("Daisy", 19, 3000.0);
    }

    /**
     * 根据id 删除用户
     */

    @Override
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
     */
    @Override
    @Transactional
    public void changemoney() {
        try {
            userDao.updateUser("SnailClimb", 22, 2000.0, 3);
            // 模拟转账过程中可能遇到的意外状况
            int temp = 1 / 0;
            userDao.updateUser("Daisy", 19, 4000.0, 4);
        } catch (Exception e) {

        }
    }
}
