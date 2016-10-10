package com.test.beans13.aop;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//�����������Ϊһ������
//���裺1.��Ҫ���������ioc����
//2.��������
@Aspect
@Component
public class LoggingAspect {
	/*//�����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼǰִ��
	@Before("execution(public int com.test.beans13.aop.ICalc.add(int, int))")
	public void beforeMethod()
	{
		System.out.println("method before");
	}*/
	
	//�����÷�����һ��ǰ��֪ͨ,��ȡ��Ӧ������
	@Before("execution(public int com.test.beans13.aop.ICalc.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		List<Object> argList=Arrays.asList(joinPoint.getArgs());
		System.out.println("method before");
		System.out.println("method:"+methodName+"--args:"+argList);
	}
	
	public void afterMethod()
	{
		System.out.println("method before");
	}
}
