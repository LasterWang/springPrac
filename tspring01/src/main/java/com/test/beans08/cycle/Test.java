package com.test.beans08.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans-cycle.xml");
		
		Bike ds=(Bike) ctx.getBean("bike");
		System.out.println(ds);
		//¹Ø±ÕiocÈÝÆ÷
		ctx.close();
	}
}
