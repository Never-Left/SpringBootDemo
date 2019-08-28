package com.dong.springboot.controller;

import com.dong.springboot.bean.User;
import com.dong.springboot.pojo.JSONResult;
import com.dong.springboot.resource.Resource;
import com.dong.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangDong
 * Date: 2019/7/29 15:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/query{name}")
    public User testQuery(@PathVariable String name) {
        return userService.selectUserByName(name);
    }

    @RequestMapping("/query/query{name}")
    public JSONResult testQuery2(@PathVariable String name) {
        User user = userService.selectUserByName(name);
        return JSONResult.ok(user);
    }

    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }


    @RequestMapping("/changemoney")
    public List<User> testchangemoney() {
        try {
            userService.changemoney();
        } catch (Exception e) {
            log.info("UserController changemoney error: " + e.getMessage() + " ");
        }
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(3);
        return "OK";
    }

}
