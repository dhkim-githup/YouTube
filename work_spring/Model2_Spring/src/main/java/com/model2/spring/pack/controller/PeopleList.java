package com.model2.spring.pack.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model2.spring.pack.service.PeopleService;
import com.model2.spring.pack.vo.People;

@Controller
public class PeopleList {
	
	@RequestMapping("/PeopleList")
	public String getPeopleList(HttpServletRequest request) {
		
		List<People> list = new ArrayList<>();
	    
	    PeopleService peopleService = new PeopleService();
	    
	    	list = peopleService.doSelect();
			// 리스트의 값을 Attribute 를 통해 주고 받는다.
			request.setAttribute("people", list);
			
			System.out.println("Hi Spring");	
		
		return "list";
	
	}

}
