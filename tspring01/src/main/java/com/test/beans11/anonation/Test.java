package com.test.beans11.anonation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans11.anonation.controller.UserController;
import com.test.beans11.anonation.repository.UserRepository;
import com.test.beans11.anonation.service.UserService;

public class Test {
	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-anonation.xml");
		
//		UserService us=(UserService) ctx.getBean("userService");
//		System.out.println(us);
//		
//		Bike ds=(Bike) ctx.getBean("bike");
//		System.out.println(ds);
//		
//		UserController uc=(UserController) ctx.getBean("userController");
//		System.out.println(uc);
//		
//		UserRepository uri=(UserRepository) ctx.getBean("userRepository");
//		System.out.println(uri);
		
		UserController uc=(UserController) ctx.getBean("userController");
		uc.execute();
	}
	
}
