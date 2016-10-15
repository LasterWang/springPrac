package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class App 
{
	public void test()
	{
		System.out.println("test...");
	}
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
    	App u=ctx.getBean(App.class);
		u.test();
    }
}
