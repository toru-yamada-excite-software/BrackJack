<%@page import="model.Player"%>
<%@page import="model.Dealer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

	<% Dealer dealer = (Dealer)request.getAttribute("dealer");
	   Player player = (Player)request.getAttribute("player");
	   boolean judgeEnd = false; %>

	<% if(player.getHandList().size() == 1) { %>
		<% if(player.getHand(0).getResult() == null) { %>
			<div>
				<h3 id="suite"><%= dealer.getHand().getHand().get(0).getSuite() %></h3>
				<h3 id="number"><%= dealer.getHand().getHand().get(0).getNumber() %></h3>
			</div>
			<div>
				<h3 id="suite">　</h3>
				<h3 id="number">　</h3>
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
		<% if(player.getHand(0).getResult() == null || player.getHand(1).getResult() == null) { %>
			<div>
				<h3 id="suite"><%= dealer.getHand().getHand().get(0).getSuite() %></h3>
				<h3 id="number"><%= dealer.getHand().getHand().get(0).getNumber() %></h3>
			</div>
			<div>
				<h3 id="suite">　</h3>
				<h3 id="number">　</h3>
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



</html>