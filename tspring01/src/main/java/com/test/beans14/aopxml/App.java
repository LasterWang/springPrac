package com.test.beans14.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
//		ICalc calc=null;
//		calc=new CalcImpl();
		
//		ICalc calc=new CalcImpl();
		
		//使用 动态代理获取对象
		//面对在每个方法中执行前后加入其它操作的需求，就要使用动态代理或者 Spring AOP 来解决
//		ICalc calc=new CalcImplProxy(new CalcImpl()).getCalcProxy();
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-aop.xml");
		ICalc calc=(ICalc) ctx.getBean(ICalc.class);
		System.out.println(calc.add(1, 2));
		System.out.println(calc.sub(1, 2));
		System.out.println(calc.mul(1, 2));
		System.out.println(calc.div(1, 3));
	}
}
