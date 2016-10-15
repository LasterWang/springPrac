package com.test.beans08.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessorInitialization:"+beanName);
		if(bean instanceof Bike)
		{
			((Bike)bean).setBrand(((Bike)bean).getBrand()+"xx");
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization:"+beanName);
		return bean;
	}

}
