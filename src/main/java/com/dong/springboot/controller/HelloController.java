package com.dong.springboot.controller;

import com.dong.springboot.pojo.JSONResult;
import com.dong.springboot.resource.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangDong
 * Date: 2019/8/28 16:17
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/resource")
    public JSONResult getResourceUser(){
        Resource resource2 = new Resource();
        BeanUtils.copyProperties(resource,resource2);
        return JSONResult.ok(resource2);
    }

}
