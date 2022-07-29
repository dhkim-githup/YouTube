package com.coffee.morning.service;

import org.springframework.stereotype.Component;

@Component
public class Latte {

	String strTaste = "달달한 맛";
	String strPrice = "4000";
	
	
	@Override
	public String toString() {
		return "Americano [strTaste=" + strTaste + ", strPrice=" + strPrice + "]";
	}
	
}
