package com.story.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.story.web.service.PeopleService;
import com.story.web.vo.People;
import com.story.web.comm.DbConn;

@Controller
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

			System.out.println("Hi PeopleList ");

		return "list";
		//return "/WEB-INF/view/list.jsp";
		

			
	}


}