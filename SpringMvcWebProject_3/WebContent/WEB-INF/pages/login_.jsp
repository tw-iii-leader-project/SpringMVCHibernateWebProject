<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h3>Login System</h3>
	<form action="login.checkController" method="post">
		<table>
			<tr>
				<td>Account:</td>
				<td><input type="text" name="user_acc" /></td>
				<td id="errMsg">${errors.msg_acc}</td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="user_pwd" /></td>
				<td id="errMsg">${errors.msg_pwd}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>