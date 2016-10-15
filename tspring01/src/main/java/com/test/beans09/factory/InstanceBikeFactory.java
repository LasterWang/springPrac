package com.test.beans09.factory;

import java.util.HashMap;
import java.util.Map;

//实例工厂方法
public class InstanceBikeFactory {
	
	private static Map<String,Bike> bikeMap=null;
	
	public InstanceBikeFactory()
	{
		bikeMap=new HashMap<String,Bike>();
		bikeMap.put("FH",new Bike("凤凰2",21));
		bikeMap.put("YJ",new Bike("永久2",28));
	}
	
	//静态工厂方法
	public Bike getBike(String name)
	{
		return bikeMap.get(name);
	}
}
