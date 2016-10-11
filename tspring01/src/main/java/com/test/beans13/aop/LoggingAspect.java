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
		System.out.println("method before:"+methodName+"--args:"+argList);
	}
	
	//后置通知：目标方法执行后（无论是否发生异常）执行的通知。
	//在后置通知总还不能访问目标方法的返回值，需要使用返回值通知来解决
	@After("execution(* com.test.beans13.aop.*.*(..))")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName);
	}
	
	//返回通知：能获取方法的返回值
	@AfterReturning(value="execution(* com.test.beans13.aop.*.*(..))",
			returning="result")
	public void afterReturningMethod(JoinPoint joinPoint,Object result)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-methodReturnValue:"+result);
	}
	
/*	//异常通知：能根据方法执行过程中的异常信息来处理,参数类型Exception 表示对所有异常做通知
	@AfterThrowing(value="execution(* com.test.beans13.aop.*.*(..))",
			throwing="ex")
	public void ExMethod(JoinPoint joinPoint,Exception ex)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-Exception:"+ex);
	}*/
	
	//异常通知：能根据方法执行过程中的异常信息来处理，参数类型ArithmeticException 表示只对ArithmeticException异常做通知
	@AfterThrowing(value="execution(* com.test.beans13.aop.*.*(..))",
			throwing="ex")
	public void ExMethod(JoinPoint joinPoint,ArithmeticException ex)
	{
		String methodName=joinPoint.getSignature().getName();
		System.out.println("after method:"+methodName+"-Exception:"+ex);
	}
	
	//环绕通知：需要携带 ProceedingJoinPoint 类型的参数
	//环绕通知相当于动态代理的全过程，ProceedingJoinPoint 类型的参数可以决定是否执行目标方法（如果不调用proceed方法则目标方法不能执行）,
	//且环绕通知方法必须有返回值，返回值即为目标方法的返回值
	@Around(value="execution(* com.test.beans13.aop.ICalc.add(..))")
	public Object aroundMehtod(ProceedingJoinPoint pjd) throws Throwable
	{
		System.out.println("环绕通知，执行方法之前...");
		Object returnValue=pjd.proceed(pjd.getArgs());
		System.out.println("环绕通知，执行方法之后");
		
		return Integer.parseInt(returnValue.toString())+1;
	}
}
