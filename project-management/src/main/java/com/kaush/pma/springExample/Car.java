package com.kaush.pma.springExample;

public class Car {

	private Engine e;
	private Tires t;
	private Doors d;
	
	public Car(Engine e,Tires t, Doors d ) {
		this.e=e;
		this.t=t;
		this.d=d;
	}
	
	// if we need to put this car object to spring contex we have to configure this as a BEAN
		// 1. we can create a @Bean inside main class 
		// 2.we can create separate @Configure class and create a @Bean inside that 
	// me widiyata karama spring contex ekata spring load wenakotama load wenawa
}
