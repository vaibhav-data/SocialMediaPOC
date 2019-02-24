package com.vaibhav.server.main.helloworld;

import org.apache.tomcat.jni.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.server.main.helloworld.*;

@RestController
public class HelloWorld {

	@GetMapping(path = "/hello")
	public String hello() {
		return "hello world";
	}

	@GetMapping(path = "/hellobean")
	public HelloWorldBean helloUser() {
		HelloWorldBean user = new HelloWorldBean("hello");
		return user;
	}
	
	@GetMapping(path = "users/{message}")
	public HelloWorldBean userPathvariable(@PathVariable String message) {
	
		return new HelloWorldBean(message);
		
	}
}
