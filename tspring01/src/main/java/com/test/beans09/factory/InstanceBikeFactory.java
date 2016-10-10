package com.test.beans09.factory;

import java.util.HashMap;
import java.util.Map;

//ʵ����������
public class InstanceBikeFactory {
	
	private static Map<String,Bike> bikeMap=null;
	
	public InstanceBikeFactory()
	{
		bikeMap=new HashMap<String,Bike>();
		bikeMap.put("FH",new Bike("���2",21));
		bikeMap.put("YJ",new Bike("����2",28));
	}
	
	//��̬��������
	public Bike getBike(String name)
	{
		return bikeMap.get(name);
	}
}
