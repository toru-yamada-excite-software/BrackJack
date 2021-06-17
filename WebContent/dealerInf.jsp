<%@page import="model.GameInf"%>
<%@page import="model.Player"%>
<%@page import="model.Dealer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% GameInf gi = (GameInf)session.getAttribute("gameInf");
   Dealer dealer = gi.getDealer();
   Player player = gi.getPlayer();
   boolean judgeEnd = false; %>

<% for(int i = 0; i < player.getHandList().size(); i++) { %>
	<% if(player.getHand(i).getResult() != null) { %>
		<% judgeEnd = true; %>
	<% } else { %>
		<% judgeEnd = false; %>
	<% } %>
<% } %>

<% if(judgeEnd) { %>
	<% for(int i = 0; i < dealer.getHand().getHand().size(); i++) {%>
		<div>
			<h3 id="suite"><%= dealer.getHand().getHand().get(i).getSuite() %></h3>
			<h3 id="number"><%= dealer.getHand().getHand().get(i).getNumber() %></h3>
		</div>
	<% } %>

	<h3 class="score">スコア：<%= dealer.getScore() %></h3>
<% } else { %>
	<div>
		<h3 id="suite"><%= dealer.getHand().getHand().get(0).getSuite() %></h3>
		<h3 id="number"><%= dealer.getHand().getHand().get(0).getNumber() %></h3>
	</div>
	<div>
		<h3 id="suite">　</h3>
		<h3 id="number">　</h3>
	</div>
<% } %>