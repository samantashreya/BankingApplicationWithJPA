package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3ForList {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//put spring.xml under src folder
		
		
		TriangleList triangle =context.getBean("triangle",TriangleList.class);
		triangle.draw();
		
		
	}

}
