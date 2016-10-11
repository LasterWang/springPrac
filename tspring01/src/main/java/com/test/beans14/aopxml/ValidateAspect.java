package com.test.beans14.aopxml;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class ValidateAspect {
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName=joinPoint.getSignature().getName();
		List<Object> argList=Arrays.asList(joinPoint.getArgs());
		System.out.println("validate method before:"+methodName+"--args:"+argList);
	}
	public void declareJointPointExpression(){}
}
