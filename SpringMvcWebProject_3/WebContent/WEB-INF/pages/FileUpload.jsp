<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form action="fileUpload.Controller" method="post"
		enctype="multipart/form-data">
		Please Select Your Picture To Upload:<br />
        <input type="file" name="myFiles" />
        <input type="submit" name="upload" value="upload"/>
	</form>
</body>
</html>