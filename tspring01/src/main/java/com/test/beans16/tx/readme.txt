һ��Spring����
1.��Spring�����ļ�������������������ص���Ҫָ���������������Դ��
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
2.�������������
	<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
3.Ϊ�������ݿ������ spring bean �ķ��� ʹ�� @Transactional ע���ע����ʾ���е����ݿ���������������

��������ļ�������
1.����Ĵ����ԣ�һ�����񷽷���������һ�����񷽷���ʱ�������÷�����ι����ڵ��÷����������С�