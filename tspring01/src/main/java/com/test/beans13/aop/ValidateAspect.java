package com.test.beans13.aop;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//�����������Ϊһ������
//���裺1.��Ҫ���������ioc����
//2.��������
@Order(1)
@Aspect
@Component
public class ValidateAspect {
	//�����÷�����һ��ǰ��֪ͨ,��ȡ��Ӧ������
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		List<Object> argList=Arrays.asList(joinPoint.getArgs());
		System.out.println("validate method before:"+methodName+"--args:"+argList);
	}
	/**
	 * �����е������
	 * 1.����һ��������������һ�㲻дʵ�ִ��룩
	 * 2.��ע�� @Pointcut("xxx") �����������ʽ
	 * 3.����������֪ͨ����ͨ�����ñ�������ǩ�����������������
	 * 4.����������֪ͨ����ʹ��ʱ����Ҫͨ��"����.����.��������ǩ��"��ʽ���� ���� ValidateAspect.declareJointPointExpression()
	 */
	@Pointcut("execution(public int com.test.beans13.aop.ICalc.add(int, int))")
	public void declareJointPointExpression(){}
}
