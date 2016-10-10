package com.test.beans09.factory;

import org.springframework.beans.factory.FactoryBean;

public class BikeFactoryBean implements FactoryBean<Bike> {
	//返回bean的对象
	public Bike getObject() throws Exception {
		return new Bike("捷安特",40);
	}
	//返回bean类型
	public Class<?> getObjectType() {
		return Bike.class;
	}
	//返回是否单例
	public boolean isSingleton() {
		return true;
	}

}
