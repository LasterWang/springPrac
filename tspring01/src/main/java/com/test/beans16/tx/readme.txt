一、Spring事务（注解声明式事务）
1.在Spring配置文件中配置事务管理器，重点是要指明让它管理的数据源。
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
2.启用事务管理器
	<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
3.为进行数据库操作的 spring bean 的方法 使用 @Transactional 注解标注，表示其中的数据库操作采用事务管理。

二、事务的几个方面（注释有一大部分在代码上）
1.事务的传播行为（propagation）：一个事务方法工作在另一个事务方法中时，被调用方法如何工作在调用方法的事务中。
	a.默认的事务行为（ Propagation.REQUIRED ），使用调用方法的事务。
	b.Propagation.REQUIRES_NEW ,被调用方法独立使用自己的事务，
	c.其他...
	
	ps.这个例子在测试时 REQUIRES_NEW 没有测试成功，最后又测试了一次，成功了，Propagation.REQUIRES_NEW 这个属性应该设置在被调用的事务方法上。
	
2.事务的隔离性(isolation)：
	a.缘由：  	脏读：对于两个事务T1、T2,T1读取了已经被T2更新但还没有被提交的字段之后，若T2回滚，T1读取的内容就是临时且无效的。
			不可重复读：对于两个事务T1、T2，T1读取了一个字段，然后T2更新了该字段，之后，T1再次读取同一个字段，值就不同了。
			幻读：对于两个事务T1、T2,T1从一个表中读取了一个字段，然后，T2在该表中插入了一些新的行，之后，如果T1再次读取同一个表，就会多出几行
	b.最常用的值为： Isolation.READ_COMMITTED 表示读已提交
3.事务对异常的回滚设置，可以使用 noRollbackFor={UserAccountException.class} 的形式 设置对UserAccountException异常不回滚
	设置为这个参数值后即便有异常的抛出仍然会执行数据库操作并部分提交或全部提交，因此，在使用这个属性的时候要格外注意。