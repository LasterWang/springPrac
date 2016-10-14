package com.test.beans16.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	BookShopDao bookShopDao;
	
	//�������ע��
	@Transactional()
	public void purchase(String username, String isbn) {
		//1.��ȡ��ĵ���
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//3.�����û����
		bookShopDao.updateUserAccount(username, price);
	}
}
