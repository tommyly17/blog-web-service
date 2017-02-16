package uts.wsd;
 
import java.io.*;

import javax.xml.bind.*;
 
public class TestJAXB implements Serializable 
{
	public static void main(String[] args) throws Exception
	{
		Articles articles = new Articles();
		articles.addArticle(new Article("5", "Article 5", "19/05/2015", "Ryan Heise", "Sports", "test test test", "test test test test test test"));
		articles.addArticle(new Article("6", "Article 5", "19/05/2015", "Ryan Heise", "Sports", "test test test", "test test test test test test"));
		// Boilerplate code to convert objects to XML...
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		try {
			m.setProperty("com.sun.xml.internal.bind.xmlHeaders", "\n<?xml-stylesheet type='text/xsl' href='articles.xsl'?>");
		}
		catch (PropertyException pex) {
			m.setProperty("com.sun.xml.bind.xmlHeaders", "\n<?xml-stylesheet type='text/xsl' href='articles.xsl'?>");
		}
		m.marshal(articles, System.out);
	}
}