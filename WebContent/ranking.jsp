<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<title>ランキング</title>
	</head>

	<body>
		<h1>BlackJack</h1>
		<h1>ランキング</h1>
		<% User user = (User)session.getAttribute("user");
		   @SuppressWarnings("unchecked")
		   ArrayList<User> ranking = (ArrayList<User>)request.getAttribute("ranking");
		   int myRank = (int)request.getAttribute("myRank");
		%>
		<h3><%= user.getName() %>でログイン中</h3>

		<table border="1">
		    <tr>
		    	<th>順位</th>
		    	<th>ニックネーム</th>
				<th>所持チップ</th>
			</tr>
		<%  User u;
			for(int i = 0; i < ranking.size(); i++) {
			u = ranking.get(i); %>

		    <tr>
		    	<th><%= i + 1 %></th>
		    	<th><%= u.getName() %></th>
				<th><%= u.getChip() %></th>
			</tr>
		<% } %>
		</table>

		<h3>自分の順位：<%= myRank %>位</h3>
		<h3>自分のチップ：<%= user.getChip() %></h3>

		<a href="mainMenu.jsp">戻る</a>

	</body>

</html>