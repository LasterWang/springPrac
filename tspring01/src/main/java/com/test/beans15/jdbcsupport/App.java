package com.test.beans15.jdbcsupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-jdbcTeamplate.xml");
		ICalc calc=(ICalc) ctx.getBean(ICalc.class);
		System.out.println(calc.add(1, 2));
		System.out.println(calc.sub(1, 2));
		System.out.println(calc.mul(1, 2));
		System.out.println(calc.div(1, 2));
	}
}
