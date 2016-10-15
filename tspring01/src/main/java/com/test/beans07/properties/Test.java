package com.test.beans07.properties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.DataSources;

public class Test {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-properties.xml");
		
		DataSource ds=(DataSource) ctx.getBean("dataSource");
		System.out.println(ds.getConnection());
	}
}
