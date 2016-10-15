package com.test.service;

public interface BookShopDao {
	//通过isbn查找书籍价格
	public int findBookPriceByIsbn(String isbn);
	//通过isbn更新书籍库存
	public void updateBookStock(String isbn);
	//更新用户账户信息
	public void updateUserAccount(String username,int price);
}
