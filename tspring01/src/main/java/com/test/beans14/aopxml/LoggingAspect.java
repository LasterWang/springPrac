package com.test.beans14.aopxml;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		List<Object> argList=Arrays.asList(joinPoint.getArgs());
		System.out.println("method before:"+methodName+"--args:"+argList);
	}
	
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName);
	}
	
	public void afterReturningMethod(JoinPoint joinPoint,Object result)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-methodReturnValue:"+result);
	}
	
	public void ExMethod(JoinPoint joinPoint,ArithmeticException ex)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-Exception:"+ex);
	}
	
	public Object aroundMehtod(ProceedingJoinPoint pjd) throws Throwable
	{
		System.out.println("环绕通知，执行方法之前...");
		Object returnValue=pjd.proceed(pjd.getArgs());
		System.out.println("环绕通知，执行方法之后");
		
		return Integer.parseInt(returnValue.toString())+1;
	}
}
