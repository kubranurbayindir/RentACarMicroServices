package com.appsdeveloperblog.rentacar.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.rentacar.users.business.abstracts.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	private UserService userService;
	private Environment environment;

	@Autowired
	public UsersController(UserService userService, Environment environment) {
		this.userService = userService;
		this.environment = environment;
	}

	@GetMapping("/status/check")
	public String status() {
		return "working on : "+environment.getProperty("local.server.port"); //get Property bölümü application yaml => dosyamızdaki değeri okur.
	}
	
	
	

}
