һ��Spring����ע������ʽ����
1.��Spring�����ļ�������������������ص���Ҫָ���������������Դ��
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
2.�������������
	<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
3.Ϊ�������ݿ������ spring bean �ķ��� ʹ�� @Transactional ע���ע����ʾ���е����ݿ���������������

��������ļ������棨ע����һ�󲿷��ڴ����ϣ�
1.����Ĵ�����Ϊ��propagation����һ�����񷽷���������һ�����񷽷���ʱ�������÷�����ι����ڵ��÷����������С�
	a.Ĭ�ϵ�������Ϊ�� Propagation.REQUIRED ����ʹ�õ��÷���������
	b.Propagation.REQUIRES_NEW ,�����÷�������ʹ���Լ�������
	c.����...
	
	ps.��������ڲ���ʱ REQUIRES_NEW û�в��Գɹ�������ֲ�����һ�Σ��ɹ��ˣ�Propagation.REQUIRES_NEW �������Ӧ�������ڱ����õ����񷽷��ϡ�
	
2.����ĸ�����(isolation)��
	a.Ե�ɣ�  	�����������������T1��T2,T1��ȡ���Ѿ���T2���µ���û�б��ύ���ֶ�֮����T2�ع���T1��ȡ�����ݾ�����ʱ����Ч�ġ�
			�����ظ�����������������T1��T2��T1��ȡ��һ���ֶΣ�Ȼ��T2�����˸��ֶΣ�֮��T1�ٴζ�ȡͬһ���ֶΣ�ֵ�Ͳ�ͬ�ˡ�
			�ö���������������T1��T2,T1��һ�����ж�ȡ��һ���ֶΣ�Ȼ��T2�ڸñ��в�����һЩ�µ��У�֮�����T1�ٴζ�ȡͬһ�����ͻ�������
	b.��õ�ֵΪ�� Isolation.READ_COMMITTED ��ʾ�����ύ
3.������쳣�Ļع����ã�����ʹ�� noRollbackFor={UserAccountException.class} ����ʽ ���ö�UserAccountException�쳣���ع�
	����Ϊ�������ֵ�󼴱����쳣���׳���Ȼ��ִ�����ݿ�����������ύ��ȫ���ύ����ˣ���ʹ��������Ե�ʱ��Ҫ����ע�⡣