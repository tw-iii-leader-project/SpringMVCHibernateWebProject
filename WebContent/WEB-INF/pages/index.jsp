<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
</head>
<body>
	<div class="loginBox">
		<form action="userCheck" method="post">
			使用者帳號 :<input id="userName" name="userName" type="text"/><br/>
			密碼 :<input id="passWord" name="passWord" type="text"/><br/>
			<button id="submit" name="submit" type="submit">送出</button>
		</form>
	
	</div>
</body>
</html>