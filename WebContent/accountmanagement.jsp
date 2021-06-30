<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<title>メニュー</title>
	</head>

	<body>
		<h1>BlackJack</h1>
		<% User user = (User)session.getAttribute("user");
		   String message = (String)request.getAttribute("message");%>
		<h3><%= user.getName() %>でログイン中</h3>
		<% if(message != null) {  %>
			<h2><%= message %></h2>
		<% } %>

		<h2>ニックネーム変更</h2>
		<form action="UpdateAccountServlet" method="post">
			<dl>
				<dt>新しいニックネーム：</dt>
				<dd><input type="text" name="name" pattern="^[0-9A-Za-z!-/:-@^_]{1,20}$" title="半角英数字記号"></dd>
			</dl>
			<input type="submit" value="変更" class="button">
		</form>

		<h2>退会</h2>
		<form action="DeleteAccountServlet" method="post">
			<input type="submit" value="退会" class="button">
		</form>

		<h2>ログアウト</h2>
		<form action="LogoutServlet" method="post">
			<input type="submit" value="ログアウト" class="button">
		</form>

		<a href="mainMenu.jsp">戻る</a>

	</body>

</html>