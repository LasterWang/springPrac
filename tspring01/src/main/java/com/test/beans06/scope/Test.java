package com.test.beans06.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-scope.xml");
		
		Bike bike=(Bike) ctx.getBean("bike");
		Bike bike2=(Bike) ctx.getBean("bike");
		System.out.println(bike==bike2);
		
		bike=null;
		
	}
}
