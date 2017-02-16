package uts.wsd;

import java.io.*;
import java.text.ParseException;

import javax.xml.bind.*;

public class ArticlesApplication {
	private String filePath;
	private Articles articles;
	
	public void setFilePath(String filePath) throws JAXBException, IOException
	{
		this.filePath = filePath;
		unmarshal(filePath);
	}
	
	public void unmarshal(String filePath) throws JAXBException, IOException
	{
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Unmarshaller u = jc.createUnmarshaller();
		 
		// Now loads the object from the file path
		FileInputStream fin = new FileInputStream(filePath);
		articles = (Articles)u.unmarshal(fin); // This loads the "articles" object
		fin.close();
	}
	
	public void saveArticles(Articles articles, String filePath) throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(Articles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //
		try { //Adds line in the xml out for JAXB to use xsl
			m.setProperty("com.sun.xml.internal.bind.xmlHeaders", "\n<?xml-stylesheet type='text/xsl' href='articles.xsl'?>");
		}
		catch (PropertyException pex) {
			m.setProperty("com.sun.xml.bind.xmlHeaders", "\n<?xml-stylesheet type='text/xsl' href='articles.xsl'?>");
		}
		m.marshal(articles, new FileOutputStream(filePath)); 
	}

	public Articles getArticles() throws JAXBException, IOException {
		unmarshal(filePath); //Loads articles from "articles.xml"
		return articles;
	}
	
	public Articles category(String category) throws JAXBException, IOException {
		articles.category(category); //applies category filter
		return articles;
	}
	
	public Articles startDate(String date) throws JAXBException, IOException, ParseException {
		articles.startDate(date); //applies start date filter
		return articles;
	}
	
	public Articles endDate(String date) throws JAXBException, IOException, ParseException {
		articles.endDate(date); //applies end date filter
		return articles;
	}
	
	public void setArticles(Articles articles) {
		this.articles = articles;
	}

	public String getFilePath() {
		return filePath;
	}
	
	public String listArticles() {
		return articles.listArticles();
	}
	
	public void delete(String id) throws FileNotFoundException, JAXBException  {
		articles.deleteArticle(id); //deletes article with id specified from object
		saveArticles(articles, filePath); //saves contents of object to file
	}
}