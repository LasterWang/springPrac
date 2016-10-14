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
	
	//添加事务注解
	//1.传播属性
	//默认的传播行为值，表示使用调用者的事务统一处理
//	@Transactional(propagation=Propagation.REQUIRED)
	
	//REQUIRES_NEW：被调用方法使用自己的事务，过程中调用方法的事务被挂起，待被调用方法事务执行完成，调用方法的事务重新开始执行。
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	
	//2.隔离属性
	//防止出现数据读取时的问题， 用isolation来设置事务的隔离级别
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED)
	
	//3.回滚属性：默认情况下，Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性来进行设置
	//noRollbackFor 其中一个用于设置对哪些异常类不进行回滚属性，大多时候并不使用这个
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			noRollbackFor={UserAccountException.class})

	//4.使用readOnly指定事务的只读属性，
	//表示这个事务只读取数据单不更新数据，这样可以帮助数据库引擎优化事务
	//如果真的是一个只读取数据库值的方法，应设置 readOnly=true
//	@Transactional(propagation=Propagation.REQUIRES_NEW,
//			isolation=Isolation.READ_COMMITTED,
//			readOnly=false)
	//5.timeout ，指定强制回滚之前事务可以占用链接的时间。单位为秒
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3)
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
