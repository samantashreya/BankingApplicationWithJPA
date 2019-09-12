package com.cg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

//aftewr the initializtn of bean if u want to extend the functionality of bean or make any configuration changes
public class DisplayNameBeanPostProcessor implements BeanPostProcessor {
//always return bean as we need to pass the changes in bean 
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("PostProcess after Initialization"+beanName);
		if(beanName.equals("triangle")) {
			((TriangleForPoint)bean).getPointC().getX();
			((TriangleForPoint)bean).getPointC().getY();
			
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("PostProcess before Initialization"+beanName);
		return bean;
	}

}
