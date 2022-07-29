<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<jsp:useBean id="dbConn" class="comm.DbConn" scope="page" />


<%
	Connection conn = null; // DB 에 connection 된 객체를 저장 
    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
    ResultSet rs = null;     // select 결과값을 받아옮
    String qry="";
    
    conn = dbConn.getConn();
    	
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select </title>
</head>
<body>


<h1> ☞  HTML -> Servlet -> Jsp </h1>

 <a href="/Jsp_Start/index.html">● Home </a>
 <p>
 
 <table style="width: 400px;" border="0">
		<tr style="height: 40px">
			<td>ID</td>
			<td align="center">이름</td>
			<td align="center">나이</td>
			<td align="center">등록일자</td>			
			<td> 삭제 </td>
		</tr>
		
	<%
	
	  try{
		  	
		  	
		    String strId="";
			 /* Result Set , Print */	
			qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
				+" from people ";
			
			ps = conn.prepareStatement(qry);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				strId = rs.getString("id");
			%>	
				<tr style="height: 40px">
				<td><%=strId%></td>
				<td align="center"><%=rs.getString("name")%></td>
				<td align="center"><%=rs.getString("age")%></td>
				<td align="center"><%=rs.getString("dati")%></td>
				<%-- <td><a href="/Jsp_Start/Delete?id=<%=strId%>">삭제 </a></td> --%>
				<td><a href="/Jsp_Start/jsp/delete.jsp?id=<%=strId%>">삭제 </a></td>
				
			</tr>	
			<%
			}		
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
		
	%>	
		
		
	</table>

</body>
</html>