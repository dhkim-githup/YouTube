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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/* Db Connection */
		Connection conn = null; // DB �� connection �� ��ü�� ���� 
		PreparedStatement ps = null;  // connection ��ü�� ���๮�� ������ ����(â��)
		ResultSet rs = null;     // select ������� �޾ƿ�

		DbConn db = new DbConn();
		
		
		try{
		conn = db.getConn();
		
		
		/* get Parameter */
		 String strID 	= request.getParameter("id");
		
		 /* Result Set , Print */	
		 String	qry = " delete from people where id=?";
			 
			ps = conn.prepareStatement(qry);			
			ps.setString(1, strID);
			
			ps.executeUpdate();
			
			conn.commit();
			System.out.println("Delete : "+strID);				
			
		
	    }catch (Exception e) {
		   try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();		
		 }finally {
			 /* Close */ 
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();			
			}catch (Exception e2) {			
			}
		}
		
		/* Member List ȭ������ �̵� */
		String strForward = "/Member_List";
		
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
