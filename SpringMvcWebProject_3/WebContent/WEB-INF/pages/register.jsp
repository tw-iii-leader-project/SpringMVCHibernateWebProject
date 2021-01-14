<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h3>Register System</h3>
<form action="register.checkController" method="post">
<table>
 <tr>
  <td>Account:</td>
  <td><input type="text" name="userName"/></td>
  <td id="errMsg">${errors.msg_acc}</td>
 </tr>
 
 <tr>
  <td>Password:</td>
  <td><input type="password" name="userPwd"/></td>
  <td id="errMsg">${errors.msg_pwd}</td>
 </tr>
 
 <tr>
  <td>NAME:</td>
  <td><input type="text" name="name"/></td>
  <td id="errMsg">${errors.msg_name}</td>
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
  <td>請點選身分</td>
  <td><input type="radio" name="authcode" value="1" checked="checked"/>買家</td>
  <td><input type="radio" name="authcode" value="0"/>賣家</td>
  <td id="errMsg">${errors.msg_authcode}</td>
 </tr>
 
 <tr>
<td><input type="submit" value="Send"/></td>
</tr>
</table>
</form>
</body>
</html>