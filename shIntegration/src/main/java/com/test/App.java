package com.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	private ApplicationContext ctx=null;
	{
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test
    public void test( )
    {
    	DataSource u=ctx.getBean(DataSource.class);
		System.out.println("sss"+u);
    }
}
