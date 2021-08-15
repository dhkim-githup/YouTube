<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*,com.model2.spring.di.vo.*" %>


<%		
	List<People_lombok> list2 = (ArrayList<People_lombok>)request.getAttribute("people");	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select </title>
</head>
<body>


<h1> ■모델 2 , Spring </h1>

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
			for(People_lombok p : list2){
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