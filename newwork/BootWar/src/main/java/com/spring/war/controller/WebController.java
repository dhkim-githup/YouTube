package com.spring.war.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
	       model.addAttribute("test","이거슨 model로 가져온값이다!");
		
	       System.out.println("sample/test");
		return "sample/test";
	}
	
	@RequestMapping("/hello")
	public String doHello() {
		
	       System.out.println("hello.html");
		return "hello";
	}

}
