package javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
	
	@Bean
	public Animal getBird(){
		return new Bird();
	}
}
