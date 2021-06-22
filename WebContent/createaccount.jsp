<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/login.css">
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
				<dd><input type="text" name="id" pattern="^[0-9A-Za-z!-/:-@^_]{1,20}$" title="半角英数字記号"></dd>
				<dt>ニックネーム：</dt>
				<dd><input type="text" name="name"></dd>
				<dt>パスワード：</dt>
				<dd><input type="password" name="password1" pattern="^[0-9A-Za-z!-/:-@^_]{6,20}$" title="半角英数字記号"></dd>
				<dt>パスワード再確認：</dt>
				<dd><input type="password" name="password2" pattern="^[0-9A-Za-z!-/:-@^_]{6,20}$" title="半角英数字記号"></dd>
			</dl>

				<input type="submit" value="登録" class="">
		</form>

		<a href="login.jsp">戻る</a>

	</body>

</html>