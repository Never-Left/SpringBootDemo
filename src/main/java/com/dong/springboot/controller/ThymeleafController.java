package com.dong.springboot.controller;

import com.dong.springboot.bean.User;
import com.dong.springboot.resource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

	@Autowired
	private Resource resource;

	@RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "thymeleaf/index";
    }
	
	@RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }
	
	@RequestMapping("test")
    public String test(ModelMap map) {
		
		User u = new User();
		u.setName("superadmin");
		u.setAge(18);
		u.setPassword("123465");
		u.setBirthday(new Date());
		u.setDesc("<font color='green'><b>这里是绿色的！</b></font>");
		
		map.addAttribute("user", u);
		
		User u1 = new User();
		u1.setAge(18);
		u1.setName("ygg");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(22);
		u2.setName("zgg");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(u);
		userList.add(u1);
		userList.add(u2);
		
		map.addAttribute("userList", userList);
		
        return "thymeleaf/test";
    }
	
	@PostMapping("postform")
    public String postform(User u) {
		
		System.out.println("姓名：" + u.getName());
		System.out.println("年龄：" + u.getAge());
		
        return "redirect:/th/test";
    }
	
	@RequestMapping("showerror")
    public String showerror(User u) {
		
		int a = 1 / 0;
		
        return "redirect:/th/test";
    }
}