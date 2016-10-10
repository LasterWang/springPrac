package com.test.beans10.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class BikeFactoryBean implements FactoryBean<Bike> {
	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//����bean�Ķ���
	public Bike getObject() throws Exception {
		return new Bike(brand,40);
	}
	//����bean����
	public Class<?> getObjectType() {
		return Bike.class;
	}
	//�����Ƿ���,ȷ������������ص�bean�Ƿ�Ϊ��̬ʵ��
	public boolean isSingleton() {
		return true;
	}

}
