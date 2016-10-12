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
	//���������Ƿ�ɹ�
	@Test
	public void testDataSource() throws SQLException
	{
		DataSource ds=ctx.getBean(DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	//����
	@Test
	public void update()
	{
//		int res=jdbcTemplate.update("update user set name='bbb' where id=1");
		String sql="update user set name=? where id=?";
		jdbcTemplate.update(sql,"JACK",1);
	}
	//��������
	@Test
	public void batchUpdate()
	{
		String sql="insert into user(id,name,age,dept_id) values(?,?,?,?)";
		List<Object[]> batchArgs=new ArrayList<Object[]>();
		
		batchArgs.add(new Object[]{6,"����","18",2});
		batchArgs.add(new Object[]{7,"����","19",2});
		batchArgs.add(new Object[]{8,"����","20",2});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	//��ѯһ����¼���õ�һ������
	//1.RowMapper:ָ��ӳ���������У�����ʵ���ࣺBeanPropertyRowMapper
	//2.ʹ��sql ���еı�����������������Ե�ӳ�䡣
	//3.��֧�ּ������ԣ�jdbcTemplate�Ǹ�jdbc���߶���ORM���ߡ�
	@Test
	public void testQueryForObject(){
		String sql="select id,name,age,dept_id as \"dept.id\" from user where id=?";
		
		RowMapper<User> rMapper=new BeanPropertyRowMapper<User>(User.class);
		User user=jdbcTemplate.queryForObject(sql, rMapper,1);
		System.out.println(user);
	}
	
	//��ѯʵ����ļ���
	@Test
	public void testQueryForList(){
		String sql="select id,name,age from user where id>?";
		RowMapper<User> rMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> userList=jdbcTemplate.query(sql, rMapper,1);
		System.out.println(userList);
	}
	//��ȡ�����е�ֵ������ͳ�Ʋ�ѯ
	@Test
	public void queryForObject2(){
		String sql="select count(id) from user";
		int count=jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	//������Ŀ��ʹ�õ� UserDao
	@Test
	public void userDaoUse()
	{
		UserDao ud=ctx.getBean(UserDao.class);
		System.out.println(ud.get(1));
	}
}
