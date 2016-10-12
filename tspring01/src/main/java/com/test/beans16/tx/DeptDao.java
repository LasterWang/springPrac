package com.test.beans16.tx;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao extends JdbcDaoSupport{
	@Autowired
	public void setDataSource2(DataSource ds)
	{
		setDataSource(ds);
	}
	
	public Dept get(Integer id)
	{
		String sql="select id,name from dept where id=?";
		RowMapper<Dept> rowMapper=new BeanPropertyRowMapper<Dept>(Dept.class);
		Dept dept=getJdbcTemplate().queryForObject(sql, rowMapper,1);
		return dept;
	}
}
