package com.test02.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test02.service.BookShopDao;
import com.test02.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	
	/**
	 * spring hibernate 事务的流程
	 * 1.在方法开始之前
	 *  ①.获取session
	 *  ②.把session 和当前线程绑定，这样就可以在dao中使用 sessionFactory的 getcurrentSession() 方法来获取session
	 *  ③.开启事务
	 * 2.如方法正常结束，即没出现异常，则
	 *  ①.提交事务
	 *  ②.使和当前线程绑定的session解除绑定
	 *  ③.关闭session
	 * 3.若方法出现异常，则：
	 *  ①.回滚事务
	 *  ②.使和当前线程绑定的session解除绑定
	 *  ③.关闭session
	 */
	public void purchase(String username, String isbn) {
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}

}
