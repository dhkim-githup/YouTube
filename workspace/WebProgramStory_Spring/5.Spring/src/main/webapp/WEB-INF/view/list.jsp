<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.story.web.vo.*" %>


<%
	String strName = request.getParameter("name");
	out.println("Parameter => "+strName);

	List<People> list2 = (ArrayList<People>)request.getAttribute("people");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select </title>
</head>
<body>


<h1>  ☞  HTML -> Servlet -> Jsp -> MVC -> Spring Boot </h1>

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
			for(People p : list2){
				strId = p.getStrID();
			%>
				<tr style="height: 40px">
				<td><%=strId%></td>
				<td align="center"><%=p.getStrName()%></td>
				<td align="center"><%=p.getStrAge()%></td>
				<td align="center"><%=p.getStrDati()%></td>
				<td><a href="/DeletePeople?id=<%=strId%>">삭제 </a></td>
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