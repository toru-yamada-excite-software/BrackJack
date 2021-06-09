<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

		<% String message = (String)request.getAttribute("message"); %>
		<% if(message == null) { %>
			<form action="GameServlet" method="post">
				<button type='submit' name='command' value='0'>hit</button>
 				<button type='submit' name='command' value='1'>stand</button>
			</form>
		<% } else { %>
			<form action="StartGameServlet" method="post">
				<input type="submit" value="再戦">
			</form>
		<% } %>

</body>

</html>