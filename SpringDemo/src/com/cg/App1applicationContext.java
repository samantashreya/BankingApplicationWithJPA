package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1applicationContext {
	
		public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			//put spring.xml under src folder
			
			
			Triangle triangle =context.getBean("triangle",Triangle.class);
			triangle.draw();
			
			
		}

	}

