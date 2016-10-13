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
		//�����Ŀ���Ƿ��㹻�������������׳��쳣
		String sql2="select stock from book_stock where isbn=?";
		int stock=jdbcTemplate.queryForObject(sql2, Integer.class,isbn);
		if (stock==0) {
			throw new BookStockException("��治��");
		}
		String sql="update book_stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql,isbn);
	}

	public void updateUserAccount(String username, int price) {
		//��֤����Ƿ��㹻,�����㣬�׳��쳣
		String sql2="select balance from account where username=?";
		float balance=jdbcTemplate.queryForObject(sql2, Float.class,username);
		if (balance<price) {
			throw new UserAccountException("����");
		}
		String sql="update account set balance=balance-? where username=?";
		jdbcTemplate.update(sql,price,username);
	}

}
