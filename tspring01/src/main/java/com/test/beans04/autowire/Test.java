package com.test.beans04.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-autowire.xml");
		User u=(User) ctx.getBean("user");
		System.out.println(u);
		
	}
}
