<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<% Player player = (Player)request.getAttribute("player"); %>

	<% if(player.getHandList().size() == 1) { %>
		<% if(player.getHand(0).getResult() == null) { %>
			<form action="GameServlet" method="post">
				<button class="command" type='submit' name='command' value='0'>hit</button>
 				<button class="command" type='submit' name='command' value='2'>stand</button>
			</form>
		<% } else { %>
			<form action="StartGameServlet" method="post">
				<input class="command" type="submit" value="再戦">
				<jsp:include page="betChip.jsp"></jsp:include>
			</form>
		<% } %>
	<% } else { %>
		<% if (player.getHand(0).getResult() == null && player.getHand(1).getResult() == null) { %>
			<form action="GameServlet" method="post">
				<button class="command" type='submit' name='command' value='0'>hit</button>
				<button class="command" type='submit' name='command' value='1'>hit</button>
 				<button class="command" type='submit' name='command' value='2'>stand</button>
			</form>
		<% } else if(player.getHand(0).getResult() == null) { %>
			<form action="GameServlet" method="post">
				<button class="command" type='submit' name='command' value='0'>hit</button>
 				<button class="command" type='submit' name='command' value='2'>stand</button>
			</form>
		<% } else if(player.getHand(1).getResult() == null) { %>
			<form action="GameServlet" method="post">
				<button class="command" type='submit' name='command' value='1'>hit</button>
 				<button class="command" type='submit' name='command' value='2'>stand</button>
			</form>
		<% } else { %>
			<form action="StartGameServlet" method="post">
				<input class="command" type="submit" value="再戦">
				<jsp:include page="betChip.jsp"></jsp:include>
			</form>
		<% } %>
	<% } %>

</html>