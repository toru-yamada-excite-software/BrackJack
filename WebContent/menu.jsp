<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="GameLogServlet" method="get">
	<input class="menu" type="submit" value="戦績表示">
</form>

<form action="RankingServlet" method="get">
	<input class="menu" type="submit" value="ランキング表示">
</form>

<form action="accountmanagement.jsp">
	<input class="menu" type="submit" value="ニックネーム変更">
</form>

<form action="LogoutServlet" method="post">
	<input class="menu" type="submit" value="ログアウト">
</form>
