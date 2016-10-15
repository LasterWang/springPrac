package com.test.beans13.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//使用java的动态代理
public class CalcImplProxy{
	public CalcImplProxy(ICalc target)
	{
		this.target=target;
	}
	//要代理的对象
	private ICalc target;
	
	public ICalc getCalcProxy()
	{
		ICalc proxy=null;
		//代理对象由哪一个类加载器加载
		ClassLoader loader=target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces=new Class[]{ICalc.class};
		//当调用代理对象其中的方法时，该执行的代码
		InvocationHandler h=new InvocationHandler() {
			/**
			 * proxy:正在返回的代理对象,一般情况下，在invoke方法中都不使用该对象
			 * method:正在被调用的方法
			 * args:调用方法时传入的参数
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//此方法内部一般不直接调用代理对象 proxy，易形成循环调用
				String methodName=method.getName();
				//要加入的日志
				System.out.println("method "+methodName+" begins with "+Arrays.asList(args));
				//执行方法
				Object result=method.invoke(target, args);
				//日志
				System.out.println("method "+ methodName+"执行完成");
				return result;
			}
		};
		proxy=(ICalc) Proxy.newProxyInstance(loader, interfaces, h);
		
		
		return proxy;
	}

}
