package com.test.beans17.tx.xml;

public interface BookShopDao {
	//根据书号获取书的单价
	public int findBookPriceByIsbn(String isbn);
	//更新书的库存，使对应的库存减一
	public void updateBookStock(String isbn);
	//更新用户的账户余额：使 username 的 balance -price
	public void updateUserAccount(String username,int price);
}
