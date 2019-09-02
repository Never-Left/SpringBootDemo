package com.dong.springboot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.util.Date;

@Data
public class User {
	
	private String name;
	
	@JsonIgnore
	private String password;
	private Integer age;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
	private Date birthday;
	
	@JsonInclude(Include.NON_NULL)
	private String desc;

}
