<%@page import="uts.wsd.User"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	User user = (User)session.getAttribute("user"); 
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Article</title>
</head>
<body>
<%
	if (user == null)
	{
%>
	<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
<%
	}
	else
	{
%>
	<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="logout.jsp">Logout</a>
<h2>Post Article</h2>
<%
	}
	if (user != null) {
%>
<form action="postAction.jsp" method="post">
	<input type="hidden" name="date" value="<%=ft.format(dNow) %>"/>
	<input type="hidden" name="author" value="<%=user.getName() %>"/>
	<p>Title: <input type="text" name="title"/></p>
	<p>Category: <input type="text" name="category"/></p>
	<p><textarea rows="2" cols="100" name="preview">This will be the short text on the front page.</textarea></p>
	<p><textarea rows="10" cols="100" name="content">This will be the article.</textarea></p>
	<input type="submit" value="Post Article">
</form>
<%
	}
	else {
%>
<p>You must be logged in to use this feature. Please login <a href="login.jsp">here</a>.</p>
<%
	}
%>
</body>
</html>