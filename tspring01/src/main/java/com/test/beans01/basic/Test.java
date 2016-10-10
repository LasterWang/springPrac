package com.test.beans01.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
//		User u=new User();
//		u.setName("lee");
//		u.sayHi();
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-beans.xml");
		User u=ctx.getBean("user",User.class);
		u.sayHi();
		
	}
}
