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

		<a href="accountmanagement.jsp">ニックネーム変更</a>

		<form action="LoginServlet" method="get">
			<input type="submit" value="ログアウト">
		</form>

	</body>

</html>