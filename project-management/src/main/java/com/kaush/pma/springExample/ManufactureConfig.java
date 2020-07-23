package com.kaush.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactureConfig {

	@Bean 
	public Car newCar() {
		Engine e = new Engine();
		Tires t = new Tires();
		Doors d = new Doors();
		
		return new Car(e,t,d);
	}
}
