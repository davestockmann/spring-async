package com.netzign.async.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AsyncApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		SplitterService app = context.getBean(SplitterService.class);
		app.process();
		System.exit(0);
	}

}
