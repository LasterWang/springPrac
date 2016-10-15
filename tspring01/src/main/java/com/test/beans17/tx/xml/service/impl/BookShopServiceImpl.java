package com.test.beans17.tx.xml.service.impl;

import com.test.beans17.tx.xml.BookShopDao;
import com.test.beans17.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {
	
	BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}

	public void purchase(String username, String isbn) {
		//������߳�˯�ߴ�����Ϊ�˲�������ĳ�ʱʱ������
//		try {
//			Thread.sleep(5000);//��λ����
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//1.��ȡ��ĵ���
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//3.�����û����
		bookShopDao.updateUserAccount(username, price);
	}
}
