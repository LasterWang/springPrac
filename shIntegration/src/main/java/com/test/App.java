package com.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.BookShopService;

public class App 
{
	private static ApplicationContext ctx=null;
	private static BookShopService bookShopService=null;
	static
	{
		ctx=new ClassPathXmlApplicationContext("beans.xml");
		bookShopService=ctx.getBean(BookShopService.class);
	}
	public static void testBookShopService()
	{
		bookShopService.purchase("AA", "1001");
	}
	
    public static void test( )
    {
    	DataSource u=ctx.getBean(DataSource.class);
		System.out.println("sss"+u);
    }
	
	public static void main(String[] args) {
		App.test();
	}
}
