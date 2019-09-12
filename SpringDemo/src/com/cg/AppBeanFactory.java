//using BeanFactory
package com.cg;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class AppBeanFactory {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		Triangle triangle = factory.getBean("triangle",Triangle.class);
		triangle.draw();
	}

}
