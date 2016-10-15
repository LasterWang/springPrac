package com.test.beans10.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-factorybean.xml");
		
		Bike ds=(Bike) ctx.getBean("bike02");
		System.out.println(ds);
		
		Bike ds2=(Bike) ctx.getBean("bike02");
		System.out.println(ds==ds2);
	}
}
