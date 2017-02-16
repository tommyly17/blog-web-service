<%@page contentType="application/xml"%><?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="article.xsl"?>

<% String id = request.getParameter("id"); %>
<% String filePath = application.getRealPath("articles.xml"); %>
<jsp:useBean id="articlesApp" class="uts.wsd.ArticlesApplication" scope="application">
    <jsp:setProperty name="articlesApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
 
<%
	uts.wsd.Articles articles = articlesApp.getArticles();
	uts.wsd.Article article = articles.getArticle(id);
%>
<article>
	<id><%=article.getId() %></id>
	<title><%=article.getTitle() %></title>
	<date><%=article.getDate() %></date>
	<author><%=article.getAuthor() %></author>
	<category><%=article.getCategory() %></category>
	<content><%=article.getContent() %></content>
</article>
