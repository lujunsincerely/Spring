package com.teaegg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		/*HelloWorld helloWorld=(HelloWorld)applicationContext.getBean("helloWorld");
		
		helloWorld.getMessage1();
		helloWorld.getMessage2();
		
		HelloIndia helloIndia=(HelloIndia) applicationContext.getBean("helloIndia");
		helloIndia.getMessage1();
		helloIndia.getMessage2();
		helloIndia.getMessage3();*/
		
		//这将确保正常关机，并调用相关的destroy方法
//		applicationContext.registerShutdownHook();
		
		TextEditor textEditor=(TextEditor) applicationContext.getBean("textEditor");
		textEditor.spellCheck();
	}
}
