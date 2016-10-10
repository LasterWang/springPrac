package com.test.beans13.aop;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面
//步骤：1.需要将该类放入ioc容器
//2.声明切面
@Aspect
@Component
public class LoggingAspect {
	/*//声明该方法是一个前置通知：在目标方法开始前执行
	@Before("execution(public int com.test.beans13.aop.ICalc.add(int, int))")
	public void beforeMethod()
	{
		System.out.println("method before");
	}*/
	
	//声明该方法是一个前置通知,获取对应方法的
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
