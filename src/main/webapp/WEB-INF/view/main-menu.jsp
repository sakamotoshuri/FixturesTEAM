<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Account ac = (Account)session.getAttribute("user");
	%>
	<h3>ログイン成功</h3>
	<p>ようこそ<%=ac.getName() %>さん</p>
	<a href="LogoutServlet">ログアウト</a>
</body>
</html>