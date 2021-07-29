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

import vo.People;
import comm.DbConn;

/**
 * Servlet implementation class PeopleList
 */
@WebServlet("/PeopleList_no")
public class CopyOfPeopleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CopyOfPeopleList() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null; // DB 에 connection 된 객체를 저장 
	    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
	    ResultSet rs = null;     // select 결과값을 받아옮
	    String qry="";
	    
	    DbConn dbConn = new DbConn();
	    conn = dbConn.getConn();
	    
	    List<People> list = new ArrayList<>();
	    
		
	   try{ 
		    /* Result Set , Print */	
			qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
				+" from people ";
			
			ps = conn.prepareStatement(qry);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// Poeple 생성자를 이용하여 값을 입력 
				People people = new People(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("dati"));
				list.add(people);				
			}
			
			System.out.println(list.size());
			
			/* 이부분에 직접 화면 출력되는 부분을 넣어본다. *
			 * 여기에 있는 부분이 향후 View 로 분리될것이다.
			 */
			// 리스트의 값을 Attribute 를 통해 주고 받는다.
			request.setAttribute("people", list);
			
			/* forward 방식 
			 * List 의 값을 Attribute 를 통해 전달한다. 
			 * */		
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
			 dispatcher.forward(request, response);
			 
			
		
	   }catch (Exception e) {
			System.out.println("Error =>"+e);			
		 }finally {
			 /* Close */ 
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();			
			}catch (Exception e2) {			
			}
		}	
		
		System.out.println("Hi Servlet Controller");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
