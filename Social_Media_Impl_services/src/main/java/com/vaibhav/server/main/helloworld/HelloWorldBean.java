package com.vaibhav.server.main.helloworld;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {
	
	public String name;
	
	protected HelloWorldBean() {}
	public HelloWorldBean(String name) {
		this.name = name;
	}
}
