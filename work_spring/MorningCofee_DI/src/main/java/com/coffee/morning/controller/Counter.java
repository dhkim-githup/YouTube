package com.coffee.morning.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.morning.service.Americano;
import com.coffee.morning.service.Cappuccino;
import com.coffee.morning.service.Latte;

@RestController
public class Counter {
	
	
	Americano americano;	
	Latte latte;	
	Cappuccino cappuccino;
	
	@Autowired
	public Counter(Americano ame, Latte la, Cappuccino ca ) {
		this.americano = ame;
		this.latte = la;
		this.cappuccino = ca;
		
	}
	
	
	@RequestMapping("/coffee/morning")
	public String doOrder(HttpServletRequest request ) {		
		
		String strReturn="";
		
		String strMenu = request.getParameter("coffee");
		
		if(strMenu.equals("1")) {
			//Americano americano = new Americano();
			strReturn = americano.toString();
			
		}else if (strMenu.equals("2")){
			//Latte latte = new Latte();
			strReturn = latte.toString();
			
		}else if (strMenu.equals("3")){
			//Cappuccino cappuccino = new Cappuccino();
			strReturn = cappuccino.toString();
			
		}
		
		return strReturn;
	}

}
