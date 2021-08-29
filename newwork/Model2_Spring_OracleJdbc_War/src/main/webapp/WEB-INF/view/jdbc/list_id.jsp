<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, com.model2.spring.vo.*" %>


<%	
	String strPath = (String)request.getAttribute("path");	
    Vo_People vo_People = (Vo_People)request.getAttribute("vo_people");	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select </title>
</head>
<body>


<h1> ■모델 2 , Spring boot - jdbc/list_id.jsp</h1>

 <a href="/index.html">● Home </a>
 <p>

 <form name="regist" action="/<%=strPath %>/PeopleUpdate" method="post">  
 <table style="width: 400px;" border="0">
		<tr style="height: 40px">
			<td> ID </td>   <td><%=vo_People.getId() %><input type="hidden" name="id" value="<%=vo_People.getId() %>" />   </td> 
		</tr>
		<tr style="height: 40px">
			<td> Name </td> <td><input type="text" name="name" value="<%=vo_People.getName() %>" /></td> 
		</tr>
		<tr style="height: 40px">
			<td> Age </td>  <td><input type="text" name="age" value="<%=vo_People.getAge() %>" />  </td> 
		</tr>		
	</table>
<input type="submit"  value="수정" style="width:200px;"> 	
</form>
</body>
</html>