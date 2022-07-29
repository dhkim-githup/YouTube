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

		/* ID �� �޴� �κ� */
		request.setCharacterEncoding("UTF-8");

	    String strID 	= request.getParameter("id");

		/* �ش� ���ڰ��� ������ Insert ��Ű�� �޼��� Call */
	    // DeleteService deleteservice = new DeleteService();
	    int intResult = deleteservice.doDelete(strID);

		/* �۾��� ���� �� ������ ��ġ ���� */
		List<People> list = new ArrayList<>();

	    //PeopleService peopleService = new PeopleService();

		list = peopleService.doSelect();
		// ����Ʈ�� ���� Attribute �� ���� �ְ� �޴´�.
		request.setAttribute("people", list);

		System.out.println("Hi DeletePeople - ");

		return "list";

	}

}