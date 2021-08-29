<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, com.model2.spring.vo.*" %>


<%		
    String strPath = (String)request.getAttribute("path");
	out.println("strPath =>"+strPath);
	List<Vo_People> list2 = (ArrayList<Vo_People>)request.getAttribute("people");	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select </title>
</head>
<body>


<h1> ■모델 2 , Spring boot - jdbc/list.jsp</h1>

 <a href="/index.html">● Home </a>
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
			String strId;
	
	try{
			for(Vo_People p : list2){
				strId = p.getId();	
			%>	
				<tr style="height: 40px">
				<td><a href="/<%=strPath %>/PeopleId?id=<%=strId%>"><%=strId%></a></td>
				<td align="center"><%=p.getName()%></td>
				<td align="center"><%=p.getAge()%></td>
				<td align="center"><%=p.getDati()%></td>
				<td><a href="/<%=strPath %>/PeopleDelete?id=<%=strId%>">삭제 </a></td>
			</tr>	
			<%			
			}
				
	  }catch (Exception e) {
			System.out.println("Error =>"+e);			
		 }finally {			
		}	
		
	%>	
		
		
	</table>

</body>
</html>