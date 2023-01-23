<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Fixtures" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" >
	<h1>備品一覧</h1>
	
    <hr noshade>
	
	<br>
	
		<table border="1">
		 <tr>
			<th>備品ID</th>
			<th>備品名</th>
			<th>量</th>
			<th>カテゴリ</th>
			<th>コンテンツ</th>
		 </tr>
		
    <%
    List<Fixtures> list = (ArrayList<Fixtures>)request.getAttribute("list");
    for(Fixtures f : list) {
    %>

		 <tr>
		 	<td><%=f.getFixtures_id() %></td>
			<td><%=f.getFixtures_name() %></td>
			<td><%=f.getQuantity() %></td>
			<td><%=f.getCategory() %></td>
			<td><%=f.getContent()%></td>
		 </tr>
		 
		 <%} %>
		 
		</table>
</div>
	
</body>