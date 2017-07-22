package javaconfig;

import org.springframework.stereotype.Component;

@Component
public class Bird implements Animal {
	public void printName(){System.out.println("I am bird...");}
}
