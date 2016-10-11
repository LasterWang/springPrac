package com.test.beans15.jdbcsupport;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	
	private ApplicationContext ctx=null;
	private JdbcTemplate jdbcTemplate=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-jdbcTeamplate.xml");
		jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	@Test
	public void testDataSource() throws SQLException
	{
		DataSource ds=ctx.getBean(DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	@Test
	public void update()
	{
		
	}
}
