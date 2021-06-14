<%@page import="model.Player"%>
<%@page import="model.Dealer"%>
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

	<% Dealer dealer = (Dealer)request.getAttribute("dealer");
	   String message = (String)request.getAttribute("message");
	   String message2 = (String)request.getAttribute("message2");
	   Player splitPlayer = (Player)request.getAttribute("splitPlayer"); %>

		<% if(splitPlayer == null) { %>
			<% if(message == null) { %>
				<div>
					<h3 id="suite"><%= dealer.getHand().getHand().get(0).getSuite() %></h3>
					<h3 id="number"><%= dealer.getHand().getHand().get(0).getNumber() %></h3>
				</div>
			<% } else { %>
				<% for(int i = 0; i < dealer.getHand().getHand().size(); i++) {%>
					<div>
						<h3 id="suite"><%= dealer.getHand().getHand().get(i).getSuite() %></h3>
						<h3 id="number"><%= dealer.getHand().getHand().get(i).getNumber() %></h3>
					</div>
				<% } %>

				<h3 class="score">スコア：<%= dealer.getScore() %></h3>
			<% } %>

		<% } else { %>
			<% if(message == null || message2 == null) { %>
				<div>
					<h3 id="suite"><%= dealer.getHand().getHand().get(0).getSuite() %></h3>
					<h3 id="number"><%= dealer.getHand().getHand().get(0).getNumber() %></h3>
				</div>
			<% } else { %>
				<% for(int i = 0; i < dealer.getHand().getHand().size(); i++) {%>
					<div>
						<h3 id="suite"><%= dealer.getHand().getHand().get(i).getSuite() %></h3>
						<h3 id="number"><%= dealer.getHand().getHand().get(i).getNumber() %></h3>
					</div>
				<% } %>

				<h3 class="score">スコア：<%= dealer.getScore() %></h3>
			<% } %>
		<% } %>


</body>

</html>