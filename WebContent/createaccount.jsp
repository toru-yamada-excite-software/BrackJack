<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="login.css">
		<title>アカウント作成</title>
	</head>

	<body>
		<h1>アカウント新規登録</h1>
		<% String message = (String)request.getAttribute("message");
		   if(message != null) {%>
				<h2><%= message %></h2>
		<% } %>
		<form action="CreateAccountServlet" method="post">
			<dl>
				<dt>ID：</dt>
				<dd><input type="text" name="id"></dd>
				<dt>ニックネーム：</dt>
				<dd><input type="text" name="name"></dd>
				<dt>パスワード：</dt>
				<dd><input type="text" name="password1"></dd>
				<dt>パスワード再確認：</dt>
				<dd><input type="text" name="password2"></dd>
			</dl>

				<input type="submit" value="登録">
		</form>

		<a href="login.jsp">戻る</a>

	</body>

</html>