<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Profile</title>
			</head>
			<body>
				<a href="articles.xml">Home</a> | <a href="postArticle.jsp">Post Article</a> | <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="user">
		<h2><xsl:value-of select="title"/></h2>
		<p>Name: <xsl:value-of select="name"/></p>
		<p>Date of Birth: <xsl:value-of select="dob"/></p>
		<p>Biography: <xsl:value-of select="biography"/></p>
	</xsl:template>
</xsl:stylesheet>