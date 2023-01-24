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
	<h3 class="label-title">備品登録画面</h3>
	<form action="RegisterFixturesServlet" method="post">
 	 	  備品名<br><input type="text" style="width: 300px; height: 20px;" name="fixtures_name" placeholder="Book_name"><br>
	  		  量<br><input type="text" style="width: 300px; height: 20px;" name="quantity" placeholder="ISBN"><br>
	  カテゴリー<br>
	 		IT機器<input type="radio"name="category" value = "IT機器"><br>
	  			机<input type="radio"name="category" value = "机"><br>
	  		  イス<input type="radio"name="category" value = "イス"><br>
	  	延長コード<input type="radio"name="category" value = "延長コード"><br>
	ホワイトボード<input type="radio"name="category" value = "ホワイトボード"><br>
		  ロッカー<input type="radio"name="category" value = "ロッカー"><br>
	  		加湿器<input type="radio"name="category" value = "加湿器"><br>
	  		トイレ<input type="radio"name="category" value = "トイレ"><br>
	  詳細<br><input type="text"  style="width: 300px; height: 20px;"name="content"placeholder="例）山田 太郎"><br>
		<br>
	<button type="button" style="height: 35px;" onclick="history.back()">Cancel</button>
		      <input type="submit" style="height: 35px;" value="Sign Up">
	</form>
	</div>
	
</body>
</html>