package com.test.beans16.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int findBookPriceByIsbn(String isbn) {
		String sql="select price from book where isbn=?";
		return jdbcTemplate.queryForObject(sql, Integer.class,isbn);
	}

	public void updateBookStock(String isbn) {
		String sql="update book_stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql,isbn);
	}

	public void updateUserAccount(String username, int price) {
		String sql="update account set balance=balance-? where username=?";
		jdbcTemplate.update(sql,price,username);
	}

}
