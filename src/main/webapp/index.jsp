<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="RegisterFormServlet">会員登録へ</a><br>
	        	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<p style="color:red">ログイン失敗</p>
	<form action="LoginServlet" method="post">
		<br><p>ログイン</p>
	   <input type="text" name="mail" placeholder="メールアドレス" required="required"value="<%=request.getParameter("mail") %>" required><br>
		<input type="password" name="pw" placeholder="パスワード" required="required" required><br>
		<br>
		<button type="submit" class="btn btn-primary btn-block btn-large">サインイン</button>
	</form>
	<%
		} else {
	%>
	<form action="LoginServlet" method="post">
		<br><p>ログイン</p>
		<input type="text" name="mail"  placeholder="メールアドレス" required="required" required><br>
		<input type="password" name="pw" placeholder="パスワード" required="required" required><br>
		<br>
			<button type="submit" class="btn btn-primary btn-block btn-large">サインイン</button>
	</form>
	<%
		}
	%>
</body>
</html>