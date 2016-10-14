package com.test.beans16.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	//默认情况下，Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性来进行设置，参考BookShopServiceImpl中注释
	
	
	@Transactional
	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);
		}
	}

}
