<%@page import="model.Dealer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>

<body>

	<% Dealer dealer = (Dealer)request.getAttribute("dealer");
	   String message = (String)request.getAttribute("message"); %>
	<% if(message != null) { %>
		<% for(int i = 0; i < dealer.getHand().size(); i++) {%>
			<h3><%= dealer.getHand().get(i).getSuite() %>-<%= dealer.getHand().get(i).getNumber() %></h3>
		<% } %>

		<h3>スコア：<%= dealer.getScore() %></h3>
	<% } else { %>
		<h3><%= dealer.getHand().get(0).getSuite() %>-<%= dealer.getHand().get(0).getNumber() %></h3>
	<% } %>

</body>

</html>