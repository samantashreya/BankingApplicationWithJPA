package com.cg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//for internal bean
public class Circle implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean,ApplicationContextAware{
	private Point center;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	public void draw() {
		System.out.println("Circle Drawn");
		System.out.println("Circle Points("+center.getX()+","+center.getY());
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name"+beanName);
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Set beanFactory method called by the container");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {            //spring specific 
		System.out.println("After property set of initializing bean");
		
	}
	public void startUp() {
		System.out.println("My Init () executed");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method of disposable Bean");
		
	}
	public void myDestroy() {
		System.out.println("My destroy() executed");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
	System.out.println("set application context executed");	
	}

}
