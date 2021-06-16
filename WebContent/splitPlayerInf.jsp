<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

	<% Player player = (Player)request.getAttribute("player");
	   String message = (String)request.getAttribute("message"); %>
	<% for(int i = 0; i < player.getHand(1).getHand().size(); i++) { %>
	<div>
	<h3 id="suite"><%= player.getHand(1).getHand().get(i).getSuite() %></h3>
	<h3 id="number"><%= player.getHand(1).getHand().get(i).getNumber() %></h3>
	</div>
	<% } %>

	<% if(message == null) { %>
		<% if(player.getAscore(1) > player.getScore(1)) { %>
			<h3 class="score">スコア：<%= player.getScore(1) %> or <%= player.getAscore(1) %></h3>
		<% } else {%>
			<h3 class="score">スコア：<%= player.getScore(1) %></h3>
		<% } %>

	<% } else { %>

		<% if(player.getAscore(1) > player.getScore(1)) { %>
			<h3 class="score">スコア：<%= player.getAscore(1) %></h3>
		<% } else { %>
			<h3 class="score">スコア：<%= player.getScore(1) %></h3>
		<% } %>

	<% } %>

</html>