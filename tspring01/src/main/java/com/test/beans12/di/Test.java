package com.test.beans12.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-di.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();
	}

}
