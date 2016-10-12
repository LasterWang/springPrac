package com.test.beans16.tx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class App {
	
	private ApplicationContext ctx=null;
	private JdbcTemplate jdbcTemplate=null;
	private UserDao userDao;
	private DeptDao deptDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ctx=new ClassPathXmlApplicationContext("beans-jdbcTeamplate.xml");
		jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		userDao=ctx.getBean(UserDao.class);
		deptDao=ctx.getBean(DeptDao.class);
		namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
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
		
		System.out.println(userDao.get(1));
	}
	
	//测试继承JdbcDaoSupport 的类方法调用
	@Test
	public void deptDao()
	{
		System.out.println(deptDao.get(1));
	}
	
	//测试namedParameterJdbcTemplate
	/**
	 * 可以给参数取名
	 * 1.好处：编码不易出错，易于维护。
	 * 2.缺点：编码比较麻烦。
	 */
	@Test
	public void testnamedParameterJdbcTemplate()
	{
		String sql="insert into user(id,name,age,dept_id) values(:id,:name,:age,:dept_id)";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", 9);
		paramMap.put("name", "lisa");
		paramMap.put("age", 29);
		paramMap.put("dept_id", 2);
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	/*
	 * 使用具名参数，可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新
	 * 1.sql语句中的参数名和类的属性一致
	 * 2.使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数
	 */
	@Test
	public void testnamedParameterJdbcTemplate2()
	{
		String sql="insert into user(id,name,age) values(:id,:name,:age)";
		User user=new User();
		user.setId(10);
		user.setName("linda");
		user.setAge(30);
		
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(user);
		
		namedParameterJdbcTemplate.update(sql, parameterSource);
	}
	
}
