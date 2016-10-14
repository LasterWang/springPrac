package com.test.beans17.tx.xml;

import java.util.List;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}


	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);
		}
	}

}
