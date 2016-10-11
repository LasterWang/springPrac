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

//把这个类声明为一个切面
//步骤：1.需要将该类放入ioc容器
//2.声明切面
@Order(1)
@Aspect
@Component
public class ValidateAspect {
	//声明该方法是一个前置通知,获取对应方法的
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		List<Object> argList=Arrays.asList(joinPoint.getArgs());
		System.out.println("validate method before:"+methodName+"--args:"+argList);
	}
	/**
	 * 进行切点的重用
	 * 1.定义一个方法（方法中一般不写实现代码）
	 * 2.用注解 @Pointcut("xxx") 声明切入点表达式
	 * 3.其他的切面通知方法通过调用本方法的签名来调用切入点声明
	 * 4.其他切面类通知方法使用时，需要通过"包名.类名.声明方法签名"方式调用 ，如 ValidateAspect.declareJointPointExpression()
	 */
	@Pointcut("execution(public int com.test.beans13.aop.ICalc.add(int, int))")
	public void declareJointPointExpression(){}
}
