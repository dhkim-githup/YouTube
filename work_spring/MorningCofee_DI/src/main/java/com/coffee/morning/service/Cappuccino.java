package com.coffee.morning.service;

import org.springframework.stereotype.Component;

@Component
public class Cappuccino {
	
	String strTaste = "우아한 맛";
	String strPrice = "5000";	
	
	@Override
	public String toString() {
		return "Americano [strTaste=" + strTaste + ", strPrice=" + strPrice + "]";
	}

}
