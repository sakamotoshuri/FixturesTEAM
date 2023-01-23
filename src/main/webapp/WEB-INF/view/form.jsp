<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/form.css">
<title>登録画面</title>
</head>
<body>
	<div class="image">
	</div>
	<div class="message">
	<h3 class="label-title">図書登録画面</h3>
	<form action="RegisterLibraryServlet" method="post">
		ID<br><input type="text" autofocus style="width: 300px; height: 20px;" name="id" placeholder="ID"><br>
  本の題名<br><input type="text" style="width: 300px; height: 20px;" name="book_name" placeholder="Book_name"><br>
	  ISBN<br><input type="text" style="width: 300px; height: 20px;" name="isbn" placeholder="ISBN"><br>
	  著者<br><input type="text"  style="width: 300px; height: 20px;"name="name"placeholder="例）山田 太郎"><br>
		<br>
	<button type="button" style="height: 35px;" onclick="history.back()">Cancel</button>
		      <input type="submit" style="height: 35px;" value="Sign Up">
	</form>
	</div>
	
</body>
</html>