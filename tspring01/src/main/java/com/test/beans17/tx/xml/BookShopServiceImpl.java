package com.test.beans17.tx.xml;


public class BookShopServiceImpl implements BookShopService {
	
	BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}

	public void purchase(String username, String isbn) {
		//下面的线程睡眠代码是为了测试事务的超时时间设置
//		try {
//			Thread.sleep(5000);//单位毫秒
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//1.获取书的单价
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}
}
