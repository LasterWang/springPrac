AOP 
һ��ע�ⷽʽ��ʹ�ò��裺
1. �� spring �����ļ�������Ҫ�Զ�ɨ��İ���
	<context:component-scan base-package="com.test.beans13.aop" use-default-filters="true"/>
2.�� spring �����ļ�����������aop֧�֡�
	<aop:aspectj-autoproxy/>
3.��д��־����ҵ���࣬LoggingAspect
4.�� LoggingAspect ��ʹ��ע�⣨ @Aspect @Component���������ע��� IOC ������ͬʱ����Ϊһ�����档
5.����Ҫ��ʹ��ע�⣨@Before���������֪ͨ����ָ����������Ϊǰ�û����֪ͨ����ͨ��������������档
6.Ϊ���淽������ JoinPoint���Ա��ȡ���ӵ���Ϣ��