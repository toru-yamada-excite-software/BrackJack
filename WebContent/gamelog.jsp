<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="model.Game"%>
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
		<h1>戦績</h1>
		<% User user = (User)session.getAttribute("user");
		   ArrayList<Game> gameList = (ArrayList<Game>)request.getAttribute("gameList");%>
		<h1><%= user.getName() %>でログイン中</h1>

		<% Game game = new Game(); %>

		<% game = gameList.get(1); %>
		<%= gameList.size()%>
		<%= game.getId() %>

		<table>
		    <tr>
				<th>勝敗</th>
				<th>日付</th>
			</tr>
		<%
			for(int i = 0; i < gameList.size(); i++) {
			game = gameList.get(1); %>

		    <tr>
				<th><%= game.getWinLose() %></th>
				<th><%= game.getPlayTime() %></th>
			</tr>
		<% } %>
		</table>

		<% game = gameList.get(1); %>
		<%= gameList.size()%>
		<%= game.getId() %>

		<a href="GameLogServlet">戦績表示</a>

	</body>

</html>