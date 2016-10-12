package com.test.beans15.jdbcsupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class App {
	
	private ApplicationContext ctx=null;
	private JdbcTemplate jdbcTemplate=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-jdbcTeamplate.xml");
		jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	//测试连接是否成功
	@Test
	public void testDataSource() throws SQLException
	{
		DataSource ds=ctx.getBean(DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	//更新
	@Test
	public void update()
	{
//		int res=jdbcTemplate.update("update user set name='bbb' where id=1");
		String sql="update user set name=? where id=?";
		jdbcTemplate.update(sql,"JACK",1);
	}
	//批量更新
	@Test
	public void batchUpdate()
	{
		String sql="insert into user(id,name,age,dept_id) values(?,?,?,?)";
		List<Object[]> batchArgs=new ArrayList<Object[]>();
		
		batchArgs.add(new Object[]{6,"张三","18",2});
		batchArgs.add(new Object[]{7,"王五","19",2});
		batchArgs.add(new Object[]{8,"马六","20",2});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	//查询一条记录，得到一个对象
	//1.RowMapper:指定映射结果集的行，常用实现类：BeanPropertyRowMapper
	//2.使用sql 中列的别名完成列明和类属性的映射。
	//3.不支持级联属性，jdbcTemplate是个jdbc工具而非ORM工具。
	@Test
	public void testQueryForObject(){
		String sql="select id,name,age,dept_id as \"dept.id\" from user where id=?";
		
		RowMapper<User> rMapper=new BeanPropertyRowMapper<User>(User.class);
		User user=jdbcTemplate.queryForObject(sql, rMapper,1);
		System.out.println(user);
	}
	
	//查询实体类的集合
	@Test
	public void testQueryForList(){
		String sql="select id,name,age from user where id>?";
		RowMapper<User> rMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> userList=jdbcTemplate.query(sql, rMapper,1);
		System.out.println(userList);
	}
	//获取单个列的值，或做统计查询
	@Test
	public void queryForObject2(){
		String sql="select count(id) from user";
		int count=jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	//测试项目中使用的 UserDao
	@Test
	public void userDaoUse()
	{
		UserDao ud=ctx.getBean(UserDao.class);
		System.out.println(ud.get(1));
	}
}
