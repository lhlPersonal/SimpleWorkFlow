package com.lhl.sw.test;

import java.util.Arrays;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"jpa/spring_jpa.xml");
		Arrays.asList(act.getBeanDefinitionNames()).forEach((n) -> {
			System.out.println(n);
		});

	}
}
