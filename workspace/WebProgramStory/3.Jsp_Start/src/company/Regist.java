package company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.DbConn;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/* Db Connection */
		Connection conn = null; // DB 에 connection 된 객체를 저장 
		PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
		ResultSet rs = null;     // select 결과값을 받아옮

		DbConn db = new DbConn();
		
		
		try{
		conn = db.getConn();
		
		
		/* get Parameter */
		 String strID 	= request.getParameter("input_id");
		 String strName 	= request.getParameter("input_name");
		 String strAge	= request.getParameter("input_age");
		
		  /*  DB work */			
		  String	qry = " Insert into people(id, name, age) "
				  			+" values (? , ?, to_number(?))";
		     
			ps = conn.prepareStatement(qry);			
			ps.setString(1, strID);
			ps.setString(2, strName);
			ps.setString(3, strAge);			
			
			ps.executeUpdate();			
			conn.commit();

			
		}catch(Exception e){	
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	

		/* Member List 화면으로 이동 */
		String strForward = "/jsp/member_list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(strForward);
		dispatcher.forward(request, response);	
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
