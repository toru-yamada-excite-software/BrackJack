<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<select name="betChip" required>
		<option value="" selected>ベット数を選択してください</option>
		<% for(int i = 1; i <= 10; i++) { %>
			<option value=<%= i %>><%= i %></option>
		<% } %>
	</select>

</html>