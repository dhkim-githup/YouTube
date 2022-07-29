
package com.story.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.story.web.service.PeopleService;
import com.story.web.service.RegistService;
import com.story.web.vo.People;

@Controller
public class Redirect {

	@Autowired
	RegistService registservice ;

	@Autowired
	PeopleService peopleService;

	/*
	@Autowired
	public RegistPeople(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	*/

	@RequestMapping("/Redirect")
	public String getRegistPeople(HttpServletRequest request) throws UnsupportedEncodingException {

		
		//return "redirect:/html/redirect.html";
		return "redirect:https://www.google.com";
		

	}

}