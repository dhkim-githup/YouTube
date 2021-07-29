package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PeopleService;
import vo.People;
import comm.DbConn;

/**
 * Servlet implementation class PeopleList
 */
@WebServlet("/PeopleList")
public class PeopleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PeopleList() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    List<People> list = new ArrayList<>();
	    
	    PeopleService peopleService = new PeopleService();
	    
	    
	    list = peopleService.doSelect();
			// 리스트의 값을 Attribute 를 통해 주고 받는다.
			request.setAttribute("people", list);
			
			/* forward 방식 
			 * List 의 값을 Attribute 를 통해 전달한다. 
			 * */		
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
			 dispatcher.forward(request, response);
		
		
		System.out.println("Hi Servlet Controller, Controller2");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
