<%@page import="uts.wsd.User"%>
<%@page import="uts.wsd.Articles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	User user = (User)session.getAttribute("user"); 	
	String id = request.getParameter("id"); 
%>
<!-- sets path to location of articles.xml -->
<% String filePath = application.getRealPath("articles.xml"); %>
<!-- loads java bean called articlesApp with contents of articles.xml -->
<jsp:useBean id="articlesApp" class="uts.wsd.ArticlesApplication" scope="application">
    <jsp:setProperty name="articlesApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
	Articles articles = articlesApp.getArticles();
	articles.deleteArticle(id);
	articlesApp.saveArticles(articles, filePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Article</title>
</head>
<body>
<% 
	if (id == null)
	{
%>
<p>Please specify an article to delete.</p>
<%
	}
	else
	{
%>
<p>Article has been deleted. Please click <a href="articles.xml">here</a> to return to the main page.</p>
<%
	}
%>
</body>
</html>