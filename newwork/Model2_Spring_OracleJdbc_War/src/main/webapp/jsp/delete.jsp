<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<jsp:useBean id="dbConn" class="com.model2.spring.di.comm.DbConn" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>


<h1> ■모델 1 </h1>

 <a href="/index.html">● Home </a>
 <p>
 
<%
		Connection conn = null; // DB 에 connection 된 객체를 저장 
		PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
		ResultSet rs = null;     // select 결과값을 받아옮
		String qry="";
		
		conn = dbConn.getConn();
    
    try{
		    String strID = request.getParameter("id");
		    
		     /* Result Set , Print */	
			qry = " delete from people where id=?";
			 
			ps = conn.prepareStatement(qry);			
			ps.setString(1, strID);
			
			ps.executeUpdate();
			
			out.println("ID "+strID+" 를 삭제했습니다.");
			
	  }catch (Exception e) {
			out.println("Error => 오류가 발생했습니다. "+e);			
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

</body>
</html>