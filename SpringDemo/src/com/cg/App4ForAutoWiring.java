package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App4ForAutoWiring {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//put spring.xml under src folder // using AbstactApplicationContext we are getting the method of .registerShutdown()
		context.registerShutdownHook(); //as soon as main shuts down container shut down--- destroy() executed
		
		Circle circle =context.getBean("circle",Circle.class);
		circle.draw();
		
		
	}


}
