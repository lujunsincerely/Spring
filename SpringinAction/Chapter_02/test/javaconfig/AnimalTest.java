package javaconfig;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AnimalConfig.class)
public class AnimalTest {
	
	@Autowired
	public Animal animal;
	
	@Test
	public void testNotNUll(){
		animal.printName();
		assertNotNull(animal);
	}
}
