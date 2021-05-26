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
		<% User user = (User)session.getAttribute("user");
		   String message = (String)request.getAttribute("message");%>
		<h1><%= user.getName() %>でログイン中</h1>
		<% if(message != null) {  %>
			<h2><%= message %></h2>
		<% } %>

		<h2>ニックネーム変更</h2>
		<form action="UpdateAccountServlet" method="post">
			<dl>
				<dt>新しいニックネーム：</dt>
				<dd><input type="text" name="name"></dd>
			</dl>
			<input type="submit" value="変更">
		</form>

		<h2>退会</h2>
		<form action="DeleteAccountServlet" method="post">
			<input type="submit" value="退会">
		</form>

		<h2>ログアウト</h2>
		<form action="./" method="get">
			<input type="submit" value="ログアウト">
		</form>

	</body>

</html>