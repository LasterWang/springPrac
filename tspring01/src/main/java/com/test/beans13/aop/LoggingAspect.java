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
		System.out.println("method before:"+methodName+"--args:"+argList);
	}
	
	//����֪ͨ��Ŀ�귽��ִ�к������Ƿ����쳣��ִ�е�֪ͨ��
	//�ں���֪ͨ�ܻ����ܷ���Ŀ�귽���ķ���ֵ����Ҫʹ�÷���ֵ֪ͨ�����
	@After("execution(* com.test.beans13.aop.*.*(..))")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName);
	}
	
	//����֪ͨ���ܻ�ȡ�����ķ���ֵ
	@AfterReturning(value="execution(* com.test.beans13.aop.*.*(..))",
			returning="result")
	public void afterReturningMethod(JoinPoint joinPoint,Object result)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-methodReturnValue:"+result);
	}
	
/*	//�쳣֪ͨ���ܸ��ݷ���ִ�й����е��쳣��Ϣ������,��������Exception ��ʾ�������쳣��֪ͨ
	@AfterThrowing(value="execution(* com.test.beans13.aop.*.*(..))",
			throwing="ex")
	public void ExMethod(JoinPoint joinPoint,Exception ex)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-Exception:"+ex);
	}*/
	
	//�쳣֪ͨ���ܸ��ݷ���ִ�й����е��쳣��Ϣ��������������ArithmeticException ��ʾֻ��ArithmeticException�쳣��֪ͨ
	@AfterThrowing(value="execution(* com.test.beans13.aop.*.*(..))",
			throwing="ex")
	public void ExMethod(JoinPoint joinPoint,ArithmeticException ex)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-Exception:"+ex);
	}
	
	//����֪ͨ����ҪЯ�� ProceedingJoinPoint ���͵Ĳ���
	//����֪ͨ�൱�ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽�������������proceed������Ŀ�귽������ִ�У�,
	//�һ���֪ͨ���������з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	@Around(value="execution(* com.test.beans13.aop.ICalc.add(..))")
	public Object aroundMehtod(ProceedingJoinPoint pjd) throws Throwable
	{
		System.out.println("����֪ͨ��ִ�з���֮ǰ...");
		Object returnValue=pjd.proceed(pjd.getArgs());
		System.out.println("����֪ͨ��ִ�з���֮��");
		
		return Integer.parseInt(returnValue.toString())+1;
	}
}
