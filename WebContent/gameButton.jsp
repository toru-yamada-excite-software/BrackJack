<%@page import="entity.User"%>
<%@page import="model.GameInf"%>
<%@page import="model.actor.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% GameInf gi = (GameInf)session.getAttribute("gameInf");
   User user = (User)session.getAttribute("user");
   Player player = gi.getPlayer(); %>

<%
if(player.isGameEnd()) {
%>

		<h3>獲得チップ：<%=player.getWinChip()%></h3>

		<form action="StartGameServlet" method="post">
			<input class="command" type="submit" value="再戦">
			<jsp:include page="betChip.jsp"></jsp:include>
		</form>

<% } else { %>
	<form action="StandServlet" method="post">
		<button class="command" type='submit' name='command'>stand</button>
	</form>
<% } %>