<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

	<a href="GameLogServlet">戦績表示</a>
	<a href="RankingServlet">ランキング表示</a>
	<a href="accountmanagement.jsp">ニックネーム変更</a>

	<form action="LogoutServlet" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>

</html>