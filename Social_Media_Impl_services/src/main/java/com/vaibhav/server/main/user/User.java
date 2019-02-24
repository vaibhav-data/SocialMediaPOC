package com.vaibhav.server.main.user;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	public String name;
	public Integer id;
	public Date birthday;
	
	protected User() {}
	public User(String name, Integer id, Date birthday) {
		super();
		this.name = name;
		this.id = id;
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", birthday=" + birthday + "]";
	}
	
	
}
