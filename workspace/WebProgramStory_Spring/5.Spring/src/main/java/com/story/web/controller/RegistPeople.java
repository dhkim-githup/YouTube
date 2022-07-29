
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
public class RegistPeople {

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

	@RequestMapping("/RegistPeople")
	public String getRegistPeople(HttpServletRequest request) throws UnsupportedEncodingException {

		/* ID , Name, Age �� �޴� �κ� */
		request.setCharacterEncoding("UTF-8");

	    String strID 	= request.getParameter("input_id");
	    String strName 	= request.getParameter("input_name");
	    String strAge	= request.getParameter("input_age");

		/* �ش� ���ڰ��� ������ Insert ��Ű�� �޼��� Call */
	    //RegistService registservice = new RegistService();
	    int intResult = registservice.doInsert(strID, strName, strAge);

		/* �۾��� ���� �� ������ ��ġ ���� */
		List<People> list = new ArrayList<>();

	    //PeopleService peopleService = new PeopleService();

		list = peopleService.doSelect();
		// ����Ʈ�� ���� Attribute �� ���� �ְ� �޴´�.
		request.setAttribute("people", list);

		System.out.println("Hi RegistPeople");

		return "list";

	}

}