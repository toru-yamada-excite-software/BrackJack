<%@page import="model.GameInf"%>
<%@page import="model.actor.Player"%>
<%@page import="model.actor.Dealer"%>
<%@page import="model.card.Card"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% GameInf gi = (GameInf)session.getAttribute("gameInf");
   Dealer dealer = gi.getDealer();
   Player player = gi.getPlayer(); %>

<%
if(player.isGameEnd()) {
%>
	<% for(Card card : dealer.getHand().getCards()) {%>
		<div>
			<h3 id="suite"><%=card.getSuitMark()%></h3>
			<h3 id="number"><%=card.getFaceCard()%></h3>
		</div>
	<%
	}
	%>

	<h3 class="score">スコア：<%=dealer.getHand().getMaxScore()%></h3>
<%
} else {
	Card card = dealer.getHand().getCards().get(0);
%>
	<div>
		<h3 id="suite"><%= card.getSuitMark()%></h3>
		<h3 id="number"><%= card.getFaceCard() %></h3>
	</div>
	<div id="hole">
		<h3 id="suite">　</h3>
		<h3 id="number">　</h3>
	</div>
<% } %>