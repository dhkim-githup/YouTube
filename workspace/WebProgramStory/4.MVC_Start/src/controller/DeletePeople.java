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

import service.DeleteService;
import service.PeopleService;
import service.RegistService;
import vo.People;
import comm.DbConn;

/**
 * Servlet implementation class PeopleList
 */
@WebServlet("/DeletePeople")
public class DeletePeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeletePeople() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	/* ID 를 받는 부분 */
		request.setCharacterEncoding("UTF-8");
    	
	    String strID 	= request.getParameter("id");
	   	
		/* 해당 인자값을 던져서 Insert 시키는 메서드 Call */
	    DeleteService deleteservice = new DeleteService();
	    int intResult = deleteservice.doDelete(strID);
	    
		/* 작업이 끝난 후 가야할 위치 지정 */
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
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}