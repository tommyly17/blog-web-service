<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
<h1>Register</h1>
<form action="welcome.jsp" method="post">
<table>
	<tr>
		<td>Full name</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Date of Birth</td>
		<td><input type="text" name="dob"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"></td>
	</tr>
		<td>Biography</td>
		<td><textarea rows="2" cols="100" name="biography">Enter short biography here.</textarea></td>
	<tr>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Register"></td>
	</tr>
</table>
</form>
</body>
</html>