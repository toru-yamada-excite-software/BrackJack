<%@page import="model.GameInf"%>
<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% GameInf gi = (GameInf)session.getAttribute("gameInf");
   Player player = gi.getPlayer();
   int judgeEnd = 0; %>

<% for(int i = 0; i < player.getHandList().size(); i++) { %>
	<% if(player.getHand(i).getResult() != null) { %>
		<% judgeEnd++; %>
	<% } %>
<% } %>

<% if(judgeEnd == player.getHandList().size()) { %>
		<form action="StartGameServlet" method="post">
			<input class="command" type="submit" value="再戦">
			<jsp:include page="betChip.jsp"></jsp:include>
		</form>

<% } else { %>
	<form action="GameServlet" method="post">
		<button class="command" type='submit' name='command' value='2'>stand</button>
	</form>
<% } %>