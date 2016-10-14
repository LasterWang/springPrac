package com.test.beans16.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ApplicationContext ctx=null;
	private BookShopDao bookShopDao=null;
	private BookShopService bookShopService=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-tx.xml");
		bookShopDao=ctx.getBean(BookShopDao.class);
		bookShopService=ctx.getBean(BookShopService.class);
	}
	
	@Test
	public void findBook(){
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	
	@Test
	public void updateBookStock()
	{
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void updateUserAccount(){
		bookShopDao.updateUserAccount("AA", 50);
	}
	
	//≤‚ ‘π∫ È
	
	@Test
	public void testPurchaseBook()
	{
		bookShopService.purchase("AA", "1001");
	}
}
