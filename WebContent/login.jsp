<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="login.css">
		<title>ログイン</title>
	</head>

	<body>
		<h1>BrackJack</h1>
		<h1>ログイン</h1>
		<% String message = (String)request.getAttribute("message");
		   if(message != null) {%>
				<h2><%= message %></h2>
		<% } %>
		<form action="LoginServlet" method="post">
			<dl>
				<dt>ID：</dt>
				<dd><input type="text" name="id" value="1" pattern="^[0-9A-Za-z]+$" title="半角英数字"></dd>
				<dt>パスワード：</dt>
				<dd><input type="text" name="password" value="p" pattern="^[0-9A-Za-z]+$" title="半角英数字"></dd>
			</dl>

			<input type="submit" value="ログイン">
		</form>

		<a href="createaccount.jsp">新規登録</a>

	</body>

</html>