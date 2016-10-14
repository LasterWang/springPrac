package com.test.beans16.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	//Ĭ������£�Spring������ʽ��������е�����ʱ�쳣���лع���Ҳ����ͨ����Ӧ���������������ã��ο�BookShopServiceImpl��ע��
	
	
	@Transactional
	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);
		}
	}

}
