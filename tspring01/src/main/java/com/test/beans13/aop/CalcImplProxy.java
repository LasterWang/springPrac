package com.test.beans13.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//ʹ��java�Ķ�̬����
public class CalcImplProxy{
	public CalcImplProxy(ICalc target)
	{
		this.target=target;
	}
	//Ҫ����Ķ���
	private ICalc target;
	
	public ICalc getCalcProxy()
	{
		ICalc proxy=null;
		//�����������һ�������������
		ClassLoader loader=target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces=new Class[]{ICalc.class};
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h=new InvocationHandler() {
			/**
			 * proxy:���ڷ��صĴ������,һ������£���invoke�����ж���ʹ�øö���
			 * method:���ڱ����õķ���
			 * args:���÷���ʱ����Ĳ���
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//�˷����ڲ�һ�㲻ֱ�ӵ��ô������ proxy�����γ�ѭ������
				String methodName=method.getName();
				//Ҫ�������־
				System.out.println("method "+methodName+" begins with "+Arrays.asList(args));
				//ִ�з���
				Object result=method.invoke(target, args);
				//��־
				System.out.println("method "+ methodName+"ִ�����");
				return result;
			}
		};
		proxy=(ICalc) Proxy.newProxyInstance(loader, interfaces, h);
		
		
		return proxy;
	}

}
