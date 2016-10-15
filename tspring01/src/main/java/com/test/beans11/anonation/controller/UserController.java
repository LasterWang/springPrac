package com.test.beans11.anonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.beans11.anonation.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public void execute()
	{
		System.out.println("user controller execute...");
		userService.add();
	}
}
