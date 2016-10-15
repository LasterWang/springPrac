package com.test.beans02.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-beans.xml");
		User u=(User) ctx.getBean("user2");
		System.out.println(u);
		
	}
}
