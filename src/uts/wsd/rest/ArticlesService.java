package uts.wsd.rest;

import uts.wsd.*;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;

import java.io.*;
import java.text.ParseException;

@Path("/news")
public class ArticlesService {
	@Context
	private ServletContext application;
	
	private ArticlesApplication getArticlesApp() throws JAXBException, IOException {
		synchronized (application) 
		{
			ArticlesApplication articlesApp = (ArticlesApplication)application.getAttribute("articlesApp");
			if (articlesApp == null) 
			{
				articlesApp = new ArticlesApplication();
				articlesApp.setFilePath(application.getRealPath("articles.xml"));
				application.setAttribute("articlesApp", articlesApp);
			}
			return articlesApp;
		}
	}
	
	@Path("articles")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Articles getArticles(@QueryParam("category") String category, @QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate) throws JAXBException, IOException, ParseException
	{
		Articles articles = getArticlesApp().getArticles();
		if (category != null)
		{
			articles.category(category);
			if (startDate != null)
			{
				articles.startDate(startDate);
				if (endDate != null)
					articles.endDate(endDate);
			}
			else if (endDate != null)
				articles.endDate(endDate);
			return articles;
		}
		else if (startDate != null)
		{
			articles.startDate(startDate); //filters start date
			if (endDate != null)
				articles.endDate(endDate); //filters end date
			return articles; //returns article
		}
		else if (endDate != null)
		{
			articles.endDate(endDate);
		}
		return articles; //if no parameters then returns all articles unfiltered
	}
}
