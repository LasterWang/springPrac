package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.BookShopService;

public class App 
{
	private ApplicationContext ctx=null;
	private BookShopService bookShopService=null;
	{
		ctx=new ClassPathXmlApplicationContext("beans.xml");
		bookShopService=ctx.getBean(BookShopService.class);
	}
	
	@Test
	public void testpu()
	{
//		bookShopService.purchase("AA", "1001");
		System.out.println("ss");
	}
	
	@Test
	public void sxx(){
		System.out.println("ss");
	}
}
