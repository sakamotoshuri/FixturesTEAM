<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/success.css">
<title>登録成功</title>
</head>
<body>
<div class="image"></div>
<div class="message">
		<h2 style="color:blue">下記の図書を登録しました。</h2>
		<table border="1" style="width: 800px;">
		<tr>
			<th>図書ID</th>
			<th>本の題名</th>
			<th>ISBN</th>
			<th>著者</th>
		</tr>
	<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String book_name = request.getParameter("book_name");
	String isbn = request.getParameter("isbn");
	String name = request.getParameter("name");

	
	int Id = Integer.parseInt(id);
	int Isbn = Integer.parseInt(isbn);
	%>
		<tr>
			<td><%=id %></td>
			<td><%=book_name %></td>
			<td><%=isbn %></td>
			<td><%=name %></td>
		</tr>
	
	
		<button type="button" style="height: 40px; width: 60px;" onclick="history.back()">Back</button>
		<br>

	</div>
</body>
</html>