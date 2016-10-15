package com.test.beans17.tx.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans17.tx.xml.service.BookShopService;
import com.test.beans17.tx.xml.service.Cashier;

public class App {
	private ApplicationContext ctx=null;
	private BookShopService bookShopService=null;
	private Cashier cashier=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-tx-xml.xml");
		bookShopService=ctx.getBean(BookShopService.class);
		cashier=ctx.getBean(Cashier.class);
	}
	
	//��������--����
	
	@Test
	public void testPurchaseBook()
	{
		bookShopService.purchase("AA", "1001");
	}
	
	//��������Ĵ�����Ϊ--����
	@Test
	public void testCheckout()
	{
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
}
