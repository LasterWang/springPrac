package com.test.beans16.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class App {
	private ApplicationContext ctx=null;
	private BookShopDao bookShopDao=null;
	private BookShopService bookShopService=null;
	private Cashier cashier=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-tx.xml");
		bookShopDao=ctx.getBean(BookShopDao.class);
		bookShopService=ctx.getBean(BookShopService.class);
		cashier=ctx.getBean(Cashier.class);
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
	
	//测试事务--购书
	
	@Test
	public void testPurchaseBook()
	{
		bookShopService.purchase("AA", "1001");
	}
	
	//测试事务的传播行为--结账
	@Test
	public void testCheckout()
	{
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
}
