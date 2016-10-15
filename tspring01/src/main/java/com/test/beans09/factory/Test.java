package com.test.beans09.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-factory.xml");
		
		Bike ds=(Bike) ctx.getBean("bike01");
		System.out.println(ds);
		
		ds=(Bike) ctx.getBean("bike02");
		System.out.println(ds);
	}
}
