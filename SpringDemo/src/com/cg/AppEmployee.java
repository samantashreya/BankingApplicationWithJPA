package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppEmployee {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// put spring.xml under src folder
		context.registerShutdownHook();

		Employee e = (Employee) context.getBean("employee");
		System.out.println(e.getDob());

	}
}
