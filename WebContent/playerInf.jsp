<%@page import="model.actor.BettingBox"%>
<%@page import="model.card.Card"%>
<%@page import="model.card.Hand"%>
<%@page import="java.util.List"%>
<%@page import="model.GameInf"%>
<%@page import="model.actor.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
GameInf gi = (GameInf)session.getAttribute("gameInf");
   Player player = gi.getPlayer();
%>

<%
List<BettingBox> boxes = player.getBoxes();
for(int i = 0; i < boxes.size(); i++) {
%>
	<%
	BettingBox box = boxes.get(i);
	Hand hand = box.getHand();
	%>

	<% for(Card card : hand.getCards()) { %>
		<div>
			<h3 id="suite"><%= card.getSuitMark()%></h3>
			<h3 id="number"><%= card.getFaceCard() %></h3>
		</div>
	<% } %>

	<%
	if(box.getResult() == null) {
	%>

		<%
		if(hand.getMaxScore() > hand.getMinScore()) {
		%>
			<h3 class="score">スコア：<%=hand.getMinScore()%> or <%=hand.getMaxScore()%></h3>
		<%
		} else {
		%>
			<h3 class="score">スコア：<%=hand.getMinScore()%></h3>
		<%
		}
		%>
		<h3>ベット：<%=box.getChip()%></h3>

		<form action="HitServlet" method="post">
			<button class="hit" type='submit' name='index' value=<%=i%>>hit</button>
		</form>

	<%
	} else {
	%>

		<h1><%=box.getResult()%></h1>

		<%
		if(hand.getMaxScore() > hand.getMinScore()) {
		%>
			<h3 class="score">スコア：<%=hand.getMaxScore()%></h3>
		<%
		} else {
		%>
			<h3 class="score">スコア：<%=hand.getMinScore()%></h3>
		<% } %>

	<% } %>

<% } %>