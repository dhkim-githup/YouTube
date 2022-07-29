package com.coffee.morning.service;

import org.springframework.stereotype.Component;

@Component
public class Americano {
	
	String strTaste = "깔끔한 맛";
	String strPrice = "3000";
	
	@Override
	public String toString() {
		return "Americano [strTaste=" + strTaste + ", strPrice=" + strPrice + "]";
	}
	
}
