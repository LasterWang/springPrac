package com.test.service.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.exception.BookStockException;
import com.test.exception.UserAccountException;
import com.test.service.BookShopDao;
@Repository
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private SessionFactory sessionFactory;
	//获取跟当前线程绑定的session
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public int findBookPriceByIsbn(String isbn) {
		String hql="select b.price from Book b where b.isbn=?";
		Query query=getSession().createQuery(hql).setString(0, isbn);
		return (Integer) query.uniqueResult();
	}

	public void updateBookStock(String isbn) {
		//验证书的库存是否充足
		String hql2="select b.stock from Book b where b.isbn=?";
		int stock=(Integer) getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
		if (stock==0) {
			throw new BookStockException("库存不足");
		}
		String hql="update Book b set b.stock=b.stock-1 where b.isbn=?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
		
	}

	public void updateUserAccount(String username, int price) {
		//验证余额是否足够
		String hql="select a.balance from Account a where a.username=?";
		int balance=(Integer) getSession().createQuery(hql).setString(0, username).uniqueResult();
		if (balance<price) {
			throw new UserAccountException("余额不足");
		}
		String hql2="update Account a set a.balance=a.balance-? where a.username=?";
		getSession().createQuery(hql2)
			.setInteger(0, price)
			.setString(1, username)
			.executeUpdate();
	}

}
