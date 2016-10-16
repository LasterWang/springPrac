package com.test02;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test02.service.BookShopService;
import com.test02.service.Cashier;

public class App 
{
	private ApplicationContext ctx=null;
	private BookShopService bookShopService=null;
	private Cashier cashier=null;
	{
		ctx=new ClassPathXmlApplicationContext("beans02.xml");
		bookShopService=ctx.getBean(BookShopService.class);
		cashier=ctx.getBean(Cashier.class);
	}
	@Test
	public void testCashier()
	{
		cashier.checkout("AA",Arrays.asList("1001","1002"));
	}
	@Test
	public void testpu()
	{
		bookShopService.purchase("AA", "1001");
	}
}
