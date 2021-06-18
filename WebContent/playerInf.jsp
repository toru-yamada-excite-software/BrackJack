<%@page import="model.GameInf"%>
<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% GameInf gi = (GameInf)session.getAttribute("gameInf");
   Player player = gi.getPlayer(); %>

<% for(int i = 0; i < player.getHandList().size(); i++) { %>

	<% for(int j = 0; j < player.getHand(i).getHand().size(); j++) { %>
		<div>
			<h3 id="suite"><%= player.getHand(i).getHand().get(j).getSuite() %></h3>
			<h3 id="number"><%= player.getHand(i).getHand().get(j).getNumber() %></h3>
		</div>
	<% } %>

	<% if(player.getHand(i).getResult() == null) { %>

		<% if(player.getAscore(i) > player.getScore(i)) { %>
			<h3 class="score">スコア：<%= player.getScore(i) %> or <%= player.getAscore(i) %></h3>
		<% } else {%>
			<h3 class="score">スコア：<%= player.getScore(i) %></h3>
		<% } %>
		<h3>ベット：<%= player.getHand(i).getChip() %></h3>

		<form action="GameServlet" method="post">
			<button class="hit" type='submit' name='command' value=<%= i %>>hit</button>
		</form>

	<% } else { %>

		<h1><%= player.getHand(i).getResult() %></h1>

		<% if(player.getAscore(i) > player.getScore(i)) { %>
			<h3 class="score">スコア：<%= player.getAscore(i) %></h3>
		<% } else { %>
			<h3 class="score">スコア：<%= player.getScore(i) %></h3>
		<% } %>

	<% } %>

<% } %>