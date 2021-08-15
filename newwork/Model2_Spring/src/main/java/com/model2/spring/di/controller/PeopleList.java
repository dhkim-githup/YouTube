package com.model2.spring.di.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model2.spring.di.service.PeopleService;
import com.model2.spring.di.vo.People;
import com.model2.spring.di.vo.People_lombok;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PeopleList {
	
	@Autowired
	PeopleService peopleService;
	
	/*
	@Autowired
	public PeopleList(PeopleService peopleService) {
		this.peopleService = peopleService;		
	}
	*/
	
	@RequestMapping("/PeopleList")
	public String getPeopleList(HttpServletRequest request) {
		
		List<People> list = new ArrayList<>();
	    
		System.out.println("1. list size"+ list.size());
	    //PeopleService peopleService = new PeopleService();
	    
	    list = peopleService.doSelect();
	   	System.out.println("2. list size"+ list.size());	
			// 리스트의 값을 Attribute 를 통해 주고 받는다.
			request.setAttribute("people", list);
			
			System.out.println("Hi Spring - DI ");	
		
		return "list";
		//return "/WEB-INF/view/list.jsp";
	
	}
	
	@RequestMapping("/PeopleList_Lombok")	
	public String getPeopleList_lombok(HttpServletRequest request) {		
		
		List<People_lombok> list = new ArrayList<>();
	    
		System.out.println("1. list size"+ list.size());
	    //PeopleService peopleService = new PeopleService();
	    
	    list = peopleService.doSelect_lombok();
	   	System.out.println("2. list size"+ list.size());	
			// 리스트의 값을 Attribute 를 통해 주고 받는다.
			request.setAttribute("people", list);
			
			System.out.println("Hi Spring - Lombok ");	
		
		return "list_lombok";
		//return "/WEB-INF/view/list.jsp";
	
	}

}
