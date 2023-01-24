<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/success.css">
<title>削除成功</title>
</head>
<body>
<div class="image"></div>
<div class="message">
<br>
<br>
<br>
	<h2 style="color:blue">下記のデータを削除しました。</h2>
	<%
	request.setCharacterEncoding("UTF-8");
	String fixtures_id = request.getParameter("id");
	int Fixtures_id = Integer.parseInt(fixtures_id);
	%>
		<h3>ID：<%=fixtures_id %></h3>
		
		<button type="button" style="height: 40px; width: 60px;" onclick="history.back()">Back</button>

	</div>
</body>
</html>