<%@page import="model.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
	<title>Insert title here</title>
</head>

<body>

		<% String message = (String)request.getAttribute("message");
		   String message2 = (String)request.getAttribute("message2");
		   Player player = (Player)request.getAttribute("player");%>
		<% if(player.getHandList().size() == 1) { %>
			<% if(message == null) { %>
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
			<% if (message == null && message2 == null) { %>
				<form action="GameServlet" method="post">
					<button class="command" type='submit' name='command' value='0'>hit</button>
					<button class="command" type='submit' name='command' value='1'>hit</button>
	 				<button class="command" type='submit' name='command' value='2'>stand</button>
				</form>
			<% } else if(message == null) { %>
				<form action="GameServlet" method="post">
					<button class="command" type='submit' name='command' value='0'>hit</button>
	 				<button class="command" type='submit' name='command' value='2'>stand</button>
				</form>
			<% } else if(message2 == null) { %>
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

</body>

</html>