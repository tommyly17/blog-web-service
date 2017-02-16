<%@page contentType="application/xml"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="user.xsl"?>

<%
String name = request.getParameter("name");	
String filePath = application.getRealPath("WEB-INF/users.xml"); 
%>
<jsp:useBean id="usersApp" class="uts.wsd.UsersApplication" scope="application">
    <jsp:setProperty name="usersApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>

<%
	uts.wsd.Users users = usersApp.getUsers();
	uts.wsd.User user = users.getUser(name);
%>
<user>
	<title>View Profile of <%=user.getName()%></title>
	<name><%=user.getName()%></name>
	<dob><%=user.getDob()%></dob>
	<biography><%=user.getBiography()%></biography>
</user>
