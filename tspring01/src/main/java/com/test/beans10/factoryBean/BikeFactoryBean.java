package com.test.beans10.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class BikeFactoryBean implements FactoryBean<Bike> {
	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//返回bean的对象
	public Bike getObject() throws Exception {
		return new Bike(brand,40);
	}
	//返回bean类型
	public Class<?> getObjectType() {
		return Bike.class;
	}
	//返回是否单例,确定这个工厂返回的bean是否为单态实例
	public boolean isSingleton() {
		return true;
	}

}
