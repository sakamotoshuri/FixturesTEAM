<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/form_delete.css">
<title>削除画面</title>
</head>
<body>
<div class="image"></div>
<div class="message">
<br>
<br>
<br>
<br>
	<h2 class="label-title">削除する備品の備品IDを入力してください。</h2>
	<form action="DeleteFixturesServlet" method="post">
		ID：<input type="text" style="width: 400px; height: 30px;"   name="fixtures_id"><br>
	<br>
		<button type="button" style="height: 35px;" onclick="history.back()">Cancel</button>
		      <input type="submit" style="height: 35px;" value="Delete">
	</form>

	</div>
</body>
</html>