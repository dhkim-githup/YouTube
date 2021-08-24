<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
	String user_id="scott";        
	String user_pw="tiger";
	String qry="";

	Connection conn = null; // DB 에 connection 된 객체를 저장 
    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
    ResultSet rs = null;     // select 결과값을 받아옮

    try {
   	    
		/* Driver Loading */
        Class.forName(driver);
	    conn = DriverManager.getConnection(dbURL, user_id, user_pw);
    	
	    conn.setAutoCommit(false); // 자동커밋 해제
	    
	    System.out.println("Connection Success");
		
        /* Result Set , Print */	
		qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
			+" from people ";
		
		ps = conn.prepareStatement(qry);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			out.println("ID : "+rs.getString("id"));
			out.println("<br>");
			out.println("Name : "+rs.getString("name"));
			out.println("<br>");
			out.println("age : "+rs.getString("age"));
			
		}			
				
		
     }catch (Exception e) {
		System.out.println("Error =>"+e);
		conn.rollback();
	 }finally {
		 /* Close */ 
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();			
		}catch (Exception e2) {			
		}
	}	

		

%>