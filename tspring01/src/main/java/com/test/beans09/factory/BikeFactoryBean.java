package com.test.beans09.factory;

import org.springframework.beans.factory.FactoryBean;

public class BikeFactoryBean implements FactoryBean<Bike> {
	//����bean�Ķ���
	public Bike getObject() throws Exception {
		return new Bike("�ݰ���",40);
	}
	//����bean����
	public Class<?> getObjectType() {
		return Bike.class;
	}
	//�����Ƿ���
	public boolean isSingleton() {
		return true;
	}

}
