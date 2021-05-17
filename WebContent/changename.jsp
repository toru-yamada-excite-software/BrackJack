<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="login.css">
		<title>メニュー</title>
	</head>

	<body>
		<h1>BrackJack</h1>
		<% User user = (User)session.getAttribute("user"); %>
		<h1><%= user.getName() %>でログイン中</h1>

		<h2>ニックネーム変更</h2>
		<form action="ControlAccountServlet" method="post">
			<dl>
				<dt>新しいニックネーム：</dt>
				<dd><input type="text" name="name"></dd>
			</dl>
			<input type="submit" value="送信">
		</form>

		<h2>退会</h2>
		<form action="ControlAccountServlet" method="get">
			<input type="submit" value="退会">
		</form>

		<form action="LoginServlet" method="get">
			<input type="submit" value="ログアウト">
		</form>

	</body>

</html>