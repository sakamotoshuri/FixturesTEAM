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
		<h2 style="color:blue">下記の備品を登録しました。</h2>
		<table border="1" style="width: 800px;">
		<tr>
			<th>備品ID</th>
			<th>備品名</th>
			<th>量</th>
			<th>カテゴリー</th>
			<th>コンテンツ</th>
		</tr>
	<%
	request.setCharacterEncoding("UTF-8");
	String fixtures_id = request.getParameter("id");
	String fixtures_name = request.getParameter("fixtures_name");
	String quantity = request.getParameter("quantity");
	String kategory = request.getParameter("kategory");
	String content = request.getParameter("content");

	
	int Fixtures_id = Integer.parseInt(fixtures_id);
	int Quantity = Integer.parseInt(quantity);
	%>
		<tr>
			<td><%=fixtures_id %></td>
			<td><%=fixtures_name %></td>
			<td><%=quantity %></td>
			<td><%=kategory %></td>
			<td><%=content %></td>
		</tr>
	
	
		<button type="button" style="height: 40px; width: 60px;" onclick="history.back()">Back</button>
		<br>

	</div>
</body>
</html>