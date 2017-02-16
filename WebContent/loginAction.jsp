<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Action</title>
</head>
<!-- gets parameter from POST method -->
<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
%>
<!-- loads java bean called usersApp with contents of users.xml -->
<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="usersApp" class="uts.wsd.UsersApplication" scope="application">
    <jsp:setProperty name="usersApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
	uts.wsd.Users users = usersApp.getUsers();
%>
<body>
<%
	if (users.login(email, password) != null)
	{
		session.setAttribute("user", users.login(email, password)); //if information correct assign session to user
%>
		<p>Login successful. Click <a href="articles.xml">here</a> to return to the main page.</p>
<%
	}
	else
	{
	//if not then return error message telling user to try again
%>
		<p>Password incorrect. Click <a href="login.jsp">here</a> to return to the login page.</p>
<%
	}
%>
</body>
</html>