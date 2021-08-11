package com.model2.spring.pack.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model2.spring.pack.service.PeopleService;
import com.model2.spring.pack.service.RegistService;
import com.model2.spring.pack.vo.People;

@Controller
public class RegistPeople {
	
	@RequestMapping("/RegistPeople")
	public String getRegistPeople(HttpServletRequest request) throws UnsupportedEncodingException {
		
		/* ID , Name, Age 를 받는 부분 */
		request.setCharacterEncoding("UTF-8");
    	
	    String strID 	= request.getParameter("input_id");
	    String strName 	= request.getParameter("input_name");
	    String strAge	= request.getParameter("input_age");
		
		/* 해당 인자값을 던져서 Insert 시키는 메서드 Call */
	    RegistService registservice = new RegistService();
	    int intResult = registservice.doInsert(strID, strName, strAge);
	    
		/* 작업이 끝난 후 가야할 위치 지정 */
		List<People> list = new ArrayList<>();
	    
	    PeopleService peopleService = new PeopleService();
		
		list = peopleService.doSelect();
		// 리스트의 값을 Attribute 를 통해 주고 받는다.
		request.setAttribute("people", list);
			
		System.out.println("Hi RegistPeople");	
		
		return "list";
	
	}

}
