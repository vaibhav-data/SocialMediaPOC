package com.vaibhav.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.vaibhav.server.main.user.UserDAO;

@SpringBootApplication
public class SocialMediaImplServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaImplServicesApplication.class, args);
		System.out.println(UserDAO.getUsers());
	}

}
