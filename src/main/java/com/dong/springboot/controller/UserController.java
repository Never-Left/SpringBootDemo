package com.dong.springboot.controller;

import java.util.Date;
import com.dong.springboot.bean.User;
import com.dong.springboot.pojo.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangDong
 * Date: 2019/7/29 15:13
 */

@RestController		// @RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
//	@ResponseBody
    public User getUser() {

        User u = new User();
        u.setName("张飞");
        u.setAge(30);
        u.setBirthday(new Date());
        u.setPassword("123456");
        u.setDesc("燕人张飞是也~~");

        return u;
    }

    @RequestMapping("/getUserJson")
//	@ResponseBody
    public JSONResult getUserJson() {

        User u = new User();
        u.setName("张飞");
        u.setAge(30);
        u.setBirthday(new Date());
        u.setPassword("123456");
        u.setDesc("燕人张飞是也~~");

        return JSONResult.success(u);
    }
}
