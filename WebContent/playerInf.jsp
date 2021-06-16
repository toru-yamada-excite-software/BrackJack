<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

	<% Player player = (Player)request.getAttribute("player");
	   String message = (String)request.getAttribute("message"); %>


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

		<% } else { %>

			<% if(player.getAscore(i) > player.getScore(i)) { %>
				<h3 class="score">スコア：<%= player.getAscore(i) %></h3>
			<% } else { %>
				<h3 class="score">スコア：<%= player.getScore(i) %></h3>
			<% } %>

		<% } %>

	<% } %>

</html>