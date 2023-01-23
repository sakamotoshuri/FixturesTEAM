<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			Account ac = (Account)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>新規会員登録</h3>
		<form action="RegisterConfirmServlet" method="post">
			名前：<input type="text" name="name" value="<%=ac.getName()%>"><br>
			メール：<input type="email" name="mail" value="<%=ac.getMail()%>"><br>
			パスワード：<input type="password" name="pw"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
    <div class="register">
	<h3>新規会員登録</h3>
	<form action="RegisterConfirmServlet" method="post">
		名前：<br><input type="text" name="name"><br>
		メール：<br><input type="email" name="mail"><br>
		パスワード：<br><input type="password" name="pw"><br>
		<input type="submit" value="登録">
	</form>
	</div>
	<%
		}
	%>
	<button type="button"  onclick="history.back(-1)">戻る</button>
</body>
</html>