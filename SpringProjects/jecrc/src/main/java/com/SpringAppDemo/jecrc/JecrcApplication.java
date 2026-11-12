package com.SpringAppDemo.jecrc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JecrcApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring.xml");

		Alien alien = (Alien) context.getBean("alien");
		alien.code();
	}
}
