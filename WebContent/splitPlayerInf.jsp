<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<title>Document</title>
</head>

<body>

	<% Player player = (Player)request.getAttribute("splitPlayer");
	   String message = (String)request.getAttribute("message"); %>
	<% for(int i = 0; i < player.getHand().size(); i++) { %>
	<div>
	<h3 id="suite"><%= player.getHand().get(i).getSuite() %></h3>
	<h3 id="number"><%= player.getHand().get(i).getNumber() %></h3>
	</div>
	<% } %>

	<% if(message == null) { %>
		<% if(player.getAscore() > player.getScore()) { %>
			<h3 class="score">スコア：<%= player.getScore() %> or <%= player.getAscore() %></h3>
		<% } else {%>
			<h3 class="score">スコア：<%= player.getScore() %></h3>
		<% } %>

	<% } else { %>

		<% if(player.getAscore() > player.getScore()) { %>
			<h3 class="score">スコア：<%= player.getAscore() %></h3>
		<% } else { %>
			<h3 class="score">スコア：<%= player.getScore() %></h3>
		<% } %>

	<% } %>

</body>

</html>