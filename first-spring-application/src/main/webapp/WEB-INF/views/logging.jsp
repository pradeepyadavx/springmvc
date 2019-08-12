<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>from jsp</title>
</head>
<body>
${error}

<form action="/login.do" method="post">

enter your name : <input type="text" name="name">
enter your pass : <input type="text" name="password">
<input type="submit" value="Login">
</form>
</body>
</html>