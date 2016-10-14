一、Spring事务
1.在Spring配置文件中配置事务管理器，重点是要指明让它管理的数据源。
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
2.启用事务管理器
	<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
3.为进行数据库操作的 spring bean 的方法 使用 @Transactional 注解标注，表示其中的数据库操作采用事务管理。

二、事务的几个方面
1.事务的传播性：一个事务方法工作在另一个事务方法中时，被调用方法如何工作在调用方法的事务中。