package com.test02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.service.BookShopService;
import com.test.service.Cashier;
@Service
public class CashierImpl implements Cashier{
	@Autowired
	private BookShopService bookShopService;
	public void checkout(String username, List<String> isbns) {
		for (String isbn: isbns) {
			bookShopService.purchase(username, isbn);
		}
	}

}
