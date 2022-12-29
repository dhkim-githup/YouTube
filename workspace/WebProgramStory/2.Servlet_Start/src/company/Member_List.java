package company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.DbConn;

/**
 * Servlet implementation class list
 */
@WebServlet("/Member_List")
public class Member_List extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Member_List() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("doGet Start position");		
		
		/* Db Connection */
		Connection conn = null; // DB 에 connection 된 객체를 저장 
		PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
		ResultSet rs = null;     // select 결과값을 받아옮

		DbConn db = new DbConn();
		conn = db.getConn();
			
		
		/* 아래가 바로 초창기 Servlet 의 위엄... */
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter w = response.getWriter();
		
		w.write("<html>\n" +
		"<head>\n" +
		" <meta charset=\"UTF-8\">\n" +
		" <title>회사 직원 리스트</title>\n" +
		"</head>\n" +
		"<body>\n" +
		"<h1> ■ 회사 직원 리스트 </h1>\n" +
		"<h1>  HTML -> Servlet  </h1>\n" +
		"<a href='./index.html'>● Home </a>\n" +
		"<p>\n" +
		"<table style='width: 400px;'>\n"+
		"<tr style='height: 40px'>\n"+
		"<th>No</th>\n"+
		"<th align='center'>이름</th>\n"+
		"<th align='center'>나이</th>\n"+
		"<th align='center'>등록일자</th>\n"+			
	    "</tr>\n");
		try{
				
			/* Result Set , Print */	
			String qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
						+" from people "
						+ " order by id "
						;
			
			ps = conn.prepareStatement(qry);			
			rs = ps.executeQuery();
		
		while(rs.next()) {
			w.write("<tr>");			
			w.write("<td align='center'>"+rs.getString("id")+"</td>");
			w.write("<td align='center'>"+rs.getString("name")+"</td>");
			w.write("<td align='center'>"+rs.getString("age")+"</td>");
			w.write("<td align='center'><a href=\"/2.Servlet_Start/Delete?id="+rs.getString("id")+"\">삭제 </a></td>");
			w.write("</tr>");
			}
		}catch(Exception e){	
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
		
w.write("</table>\n" +
		"</body>\n" +
		"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
