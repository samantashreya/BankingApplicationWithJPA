package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2ForTrianglePoint {
	

			public static void main(String[] args) {
				ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
				//put spring.xml under src folder
				
				
				TriangleForPoint triangle =context.getBean("triangle",TriangleForPoint.class);
				triangle.draw();
				
				
			}

		}



