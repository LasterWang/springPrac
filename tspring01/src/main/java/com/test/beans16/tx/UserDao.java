package com.test.beans16.tx;
//jdbcTemplate ����Ŀ�е�ʹ��

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User get(Integer id){
		String sql="select id,name,age from user where id=?";
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		User user=jdbcTemplate.queryForObject(sql, rowMapper,id);
		return user;
	}
}
