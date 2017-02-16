<%@page import="uts.wsd.Article"%>
<%@page import="uts.wsd.Articles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String filePath = application.getRealPath("articles.xml"); %>
<jsp:useBean id="articlesApp" class="uts.wsd.ArticlesApplication" scope="application">
    <jsp:setProperty name="articlesApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<%
	Articles articles = articlesApp.getArticles(); //Loads current articles from xml to articles object
	String latestID = articles.getLastArticle().getId(); //Gets the current latest ID
	int newID = Integer.parseInt(latestID) + 1; //Adds one to the latest ID to generate ID for this new article
%>
<%
	//Setting all the variables
	String id = Integer.toString(newID);
 	String title = request.getParameter("title");
 	String date = request.getParameter("date");
 	String author = request.getParameter("author");
 	String category = request.getParameter("category");
 	String preview = request.getParameter("preview");
 	String content = request.getParameter("content");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posting Article</title>
</head>
<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="logout.jsp">Logout</a>
<body>

<%
	if (title == null || category == null || preview == null || content == null)
	{
%>
		<p>Sorry, a mandatory field was missing. Please go back and fill out the fields correctly.</p>
		<p>Click <a href="postArticle.jsp">here</a> to go back.</p>
<%
	}
	else
	{
	 	Article article = new Article(id, title, date, author, category, preview, content); //creates new article object with the variables to add to the list in next line
	 	articles.addArticle(article); //adds new article to the current list of articles
		articlesApp.saveArticles(articles, filePath); //saves articles
%>
		<p>Your article has been posted. Click <a href="articles.xml">here</a> to return to main page.</p>
<%
	}
%>

</body>
</html>