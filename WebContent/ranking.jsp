<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="login.css">
		<title>ランキング</title>
	</head>

	<body>
		<h1>BrackJack</h1>
		<h1>ランキング</h1>
		<% String message = (String)request.getAttribute("message");
		   User user = (User)session.getAttribute("user");
		   @SuppressWarnings("unchecked")
		   ArrayList<User> ranking = (ArrayList<User>)request.getAttribute("ranking");
		   int myRank = (int)request.getAttribute("myRank");
		   if(message != null) {%>
				<h2><%= message %></h2>
		<% } %>

		<table>
		    <tr>
		    	<th>順位</th>
		    	<th>ニックネーム</th>
				<th>勝利数</th>
				<th>引き分け数</th>
				<th>敗北数</th>
				<th>勝率</th>
			</tr>
		<%  User u;
			for(int i = 0; i < ranking.size(); i++) {
			u = ranking.get(i); %>

		    <tr>
		    	<th><%= i + 1 %></th>
		    	<th><%= u.getName() %></th>
				<th><%= u.getWin() %></th>
				<th><%= u.getDraw() %></th>
				<th><%= (u.getPlay() - u.getWin() - u.getDraw()) %></th>
				<th><%= u.getWinRate() %></th>
			</tr>
		<% } %>
		</table>

		<h3>自分の順位：<%= myRank %>位</h3>
		<h3>自分の勝率：<%= user.getWinRate() * 100 %>%</h3>

		<a href="mainMenu.jsp">戻る</a>

	</body>

</html>