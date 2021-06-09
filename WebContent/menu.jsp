<%@page import="model.GameInf"%>
<%@page import="model.Card"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Player"%>
<%@page import="model.Dealer"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="login.css">
	<title>メニュー</title>
</head>

<body>
	<h1>BrackJack</h1>
	<% User user = (User)session.getAttribute("user");
	   GameInf gi = (GameInf)session.getAttribute("gameInf");%>
	<h1><%= user.getName() %>でログイン中</h1>

	<% if(gi.getMessage() != null) {%>
		<h1><%= gi.getMessage() %></h1>
	<% } %>

	<% if(gi.getPlayer() != null) { %>

		<h2>Dealer</h2>
		<% request.setAttribute("dealer", gi.getDealer());
		   request.setAttribute("message", gi.getMessage()); %>
		<jsp:include page="dealerInf.jsp"></jsp:include>

		<h2>Player</h2>
		<% request.setAttribute("player", gi.getPlayer());
		   request.setAttribute("message", gi.getMessage());%>
		<jsp:include page="playerInf.jsp"></jsp:include>

		<jsp:include page="gameButton.jsp"></jsp:include>

	<% } else { %>
		<form action="StartGameServlet" method="post">
			<input type="submit" value="start">
		</form>
	<% } %>

	<a href="GameLogServlet">戦績表示</a>
	<a href="RankingServlet">ランキング表示</a>
	<a href="accountmanagement.jsp">ニックネーム変更</a>

	<form action="LogoutServlet" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>

</html>