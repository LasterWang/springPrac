package com.test.beans09.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticBikeFactory {

	public static Map<String,Bike> bikeMap=new HashMap<String,Bike>();
	
	static{
		bikeMap.put("FH",new Bike("凤凰",21));
		bikeMap.put("YJ",new Bike("永久",28));
	}
	
	//静态工厂方法
	public static Bike getBike(String name)
	{
		return bikeMap.get(name);
	}
}
