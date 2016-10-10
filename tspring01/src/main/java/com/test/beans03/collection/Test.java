package com.test.beans03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-beans.xml");
//		User u=(User) ctx.getBean("user3");
//		System.out.println(u);
//		
//		DataSource ds=(DataSource) ctx.getBean("ds");
//		System.out.println(ds);
		
		User u=(User) ctx.getBean("user4");
		System.out.println(u);
	}
}
