package com.cg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPP implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		System.out.println("Bean Factory PostProcessor");
		TriangleForPoint t =(TriangleForPoint) factory.getBean("triangle");
		t.getPointA().setX(100);
		t.getPointA().setY(100);
		t.getPointB().setX(100);
		t.getPointB().setY(100);
		t.getPointC().setX(100);
		t.getPointC().setY(100);
	}

}
