<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>

<body>

	<% Player player = (Player)request.getAttribute("player");
	   String message = (String)request.getAttribute("message"); %>
	<% for(int i = 0; i < player.getHand().size(); i++) {%>
	<h3><%= player.getHand().get(i).getSuite() %>-<%= player.getHand().get(i).getNumber() %></h3>
	<% } %>

	<% if(message == null) { %>
		<h3>スコア：<%= player.getScore() %></h3>

		<% if(player.getAscore() > player.getScore()) { %>
		<h3>or</h3>
		<h3><%= player.getAscore() %></h3>
		<% } %>
	<% } else { %>

		<% if(player.getAscore() > player.getScore()) { %>
			<h3>スコア：<%= player.getAscore() %></h3>
		<% } else { %>
			<h3>スコア：<%= player.getScore() %></h3>
		<% } %>

	<% } %>

</body>

</html>