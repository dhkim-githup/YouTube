package com.story.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.story.web.service.DeleteService;
import com.story.web.service.PeopleService;
import com.story.web.service.RegistService;
import com.story.web.vo.People;
import com.story.web.comm.DbConn;

@Controller
public class DeletePeople {

	  @Autowired
	  DeleteService deleteservice;

	  @Autowired
	  PeopleService peopleService;

	  /*
	  @Autowired
	  public DeletePeople(PeopleService peopleService) {
			this.peopleService = peopleService;
	  }
	  */

	@RequestMapping("/DeletePeople")
	public String getDeletePeople(HttpServletRequest request) throws UnsupportedEncodingException {

		/* ID 를 받는 부분 */
		request.setCharacterEncoding("UTF-8");

	    String strID 	= request.getParameter("id");

		/* 해당 인자값을 던져서 Insert 시키는 메서드 Call */
	    // DeleteService deleteservice = new DeleteService();
	    int intResult = deleteservice.doDelete(strID);

		/* 작업이 끝난 후 가야할 위치 지정 */
		List<People> list = new ArrayList<>();

	    //PeopleService peopleService = new PeopleService();

		list = peopleService.doSelect();
		// 리스트의 값을 Attribute 를 통해 주고 받는다.
		request.setAttribute("people", list);

		System.out.println("Hi DeletePeople - ");

		return "list";

	}

}