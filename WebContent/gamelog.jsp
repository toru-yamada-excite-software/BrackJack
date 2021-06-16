<%@page import="java.text.SimpleDateFormat"%>
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
		<h1>BlackJack</h1>
		<h1>戦績</h1>
		<% User user = (User)session.getAttribute("user");
		   @SuppressWarnings("unchecked")
		   ArrayList<Game> gameList = (ArrayList<Game>)request.getAttribute("gameList");
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:mm:ss"); %>
		<h1><%= user.getName() %>でログイン中</h1>

		<table>
		    <tr>
				<th>獲得チップ</th>
				<th>日付</th>
			</tr>
		<% for(int i = 0; i < gameList.size(); i++) {
			Game game = gameList.get(i); %>

		    <tr>
				<th><%= game.getChip() %></th>
				<th><%= sdf.format(game.getPlayTime()) %></th>
			</tr>
		<% } %>
		</table>

		<a href="mainMenu.jsp">戻る</a>

	</body>

</html>