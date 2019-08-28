package com.dong.springboot.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 用注解注入配置文件信息
 * Created by StringelliJ IDEA.
 * User: ZhangDong
 * Date: 2019/8/28 15:58
 */
@Configuration
@ConfigurationProperties(prefix = "projects.author")
@PropertySource(value = "classpath:author.properties")
public class Resource {
    private String id;
    private String name;
    private String age;
    private String money;

    public Resource() {
    }

    public Resource(String id, String name, String age, String money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
