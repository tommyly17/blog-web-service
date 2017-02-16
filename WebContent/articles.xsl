<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="/">
		<html>
		<head>
			<h1>Articles</h1>
		</head>
		<body>
			<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
			<xsl:apply-templates/>
		</body>
		</html>
	</xsl:template>
	
	<xsl:template match="article">
		<h2><xsl:value-of select="title"/></h2>
		<p>Date: <xsl:value-of select="date"/></p>
		Author: <a><xsl:attribute name="href">user.jsp&#63;name=<xsl:value-of select="author"/></xsl:attribute><xsl:value-of select="author"/></a>
		<p>Category: <xsl:value-of select="category"/></p>
		<p><xsl:value-of select="preview"/><a><xsl:attribute name="href">article.jsp&#63;id=<xsl:value-of select="@id"/></xsl:attribute>Read More</a></p>
	</xsl:template>
	
</xsl:stylesheet>