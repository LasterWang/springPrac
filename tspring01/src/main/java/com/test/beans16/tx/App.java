package com.test.beans16.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ApplicationContext ctx=null;
	private BookShopDao bookShopDao=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-tx.xml");
		bookShopDao=ctx.getBean(BookShopDao.class);
	}
	
	@Test
	public void test(){
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
}
