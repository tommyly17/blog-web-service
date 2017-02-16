<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="usersApp" class="uts.wsd.UsersApplication" scope="application">
    <jsp:setProperty name="usersApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
	String name = request.getParameter("name");
	String dob = request.getParameter("dob");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String biography = request.getParameter("biography");
%>
<body>
<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
<%
	
	if (name == null || email == null || password == null)
	{
%>
		<p>Sorry, a mandatory field was missing. Please re-enter your information along with the required information.</p>
		<p>Click <a href="register.jsp">here</a> to go back.</p>
<%
	}
	else
	{
%>
		<% uts.wsd.User user = new uts.wsd.User(email, name, password, dob, biography); %>
		<% session.setAttribute("user", user); %>
		<% uts.wsd.Users users = usersApp.getUsers(); %>
		<% users.addUser(user); %>
		<% usersApp.marshal(users, filePath); %>
		<p>You have been registered!</p>
		<p>Click <a href="index.jsp">here</a> to proceed to the main page.</p>
<%
	}
%>
</body>
</html>