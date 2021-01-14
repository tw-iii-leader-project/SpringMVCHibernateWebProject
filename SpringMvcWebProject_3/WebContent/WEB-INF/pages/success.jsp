<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<h3>WelcomeBack</h3>
<h3>${user}</h3>
<h3>${pwd}</h3>

<form action="update.checkController" method="post">
<table>
 
 <tr>
  <td>Password:</td>
  <td><input type="password" name="userPwd"/></td>
  <td id="errMsg">${errors.msg_pwd}</td>
 </tr>
  
 <tr>
  <td>PHONE:</td>
  <td><input type="text" name="phone"/></td>
  <td id="errMsg">${errors.msg_phone}</td>
 </tr>
 
 <tr>
  <td>BIRTHDAY:</td>
  <td><input type="Date" name="birthday"/></td>
  <td id="errMsg">${errors.msg_birth}</td>
 </tr>
 
 <tr>
  <td>E-MAIL:</td>
  <td><input name="email"/></td>
  <td id="errMsg">${errors.msg_email}</td>
 </tr>
 
 <tr>
<td><input type="submit" value="Send"/></td>
</tr>
</table>
</form>

</body>
</html>