package com.test.beans16.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	BookShopDao bookShopDao;
	
	//�������ע��
	//1.��������
	//Ĭ�ϵĴ�����Ϊֵ����ʾʹ�õ����ߵ�����ͳһ����
//	@Transactional(propagation=Propagation.REQUIRED)
	
	//REQUIRES_NEW�������÷���ʹ���Լ������񣬹����е��÷��������񱻹��𣬴������÷�������ִ����ɣ����÷������������¿�ʼִ�С�
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	
	//2.��������
	//��ֹ�������ݶ�ȡʱ�����⣬ ��isolation����������ĸ��뼶��
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED)
	
	//3.�ع����ԣ�Ĭ������£�Spring������ʽ��������е�����ʱ�쳣���лع���Ҳ����ͨ����Ӧ����������������
	//noRollbackFor ����һ���������ö���Щ�쳣�಻���лع����ԣ����ʱ�򲢲�ʹ�����
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			noRollbackFor={UserAccountException.class})

	//4.ʹ��readOnlyָ�������ֻ�����ԣ�
	//��ʾ�������ֻ��ȡ���ݵ����������ݣ��������԰������ݿ������Ż�����
	//��������һ��ֻ��ȡ���ݿ�ֵ�ķ�����Ӧ���� readOnly=true
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			readOnly=false)
	//5.timeout ��ָ��ǿ�ƻع�֮ǰ�������ռ�����ӵ�ʱ�䡣��λΪ��
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3)
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
