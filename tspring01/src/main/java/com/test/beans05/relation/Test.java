package com.test.beans05.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-relation.xml");
		Address u=(Address) ctx.getBean("addressBj");
		System.out.println(u);
		u=(Address) ctx.getBean("addressXa");
		System.out.println(u);
		
		User user=(User) ctx.getBean("user");
		System.out.println(user);
		
		u=null;
		user=null;
		
	}
}
