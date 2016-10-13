package com.test.beans16.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	BookShopDao bookShopDao;
	
	public void purchase(String username, String isbn) {
		//1.获取书的单价
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
