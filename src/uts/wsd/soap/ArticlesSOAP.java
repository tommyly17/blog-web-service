package uts.wsd.soap;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.bind.JAXBException;
import javax.xml.ws.Endpoint;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import uts.wsd.Article;
import uts.wsd.Articles;
import uts.wsd.ArticlesApplication;

@WebService
public class ArticlesSOAP {
	@Resource
	private WebServiceContext context;

	private ArticlesApplication getArticlesApp() throws JAXBException, IOException
	{
		ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
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
	
	@WebMethod
	public Articles fetchArticles() {
		try {
			return getArticlesApp().getArticles();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@WebMethod
	public Article fetchArticle(String id) {
		Articles articles = null;
		try {
			articles = getArticlesApp().getArticles();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles.getArticle(id);
	}
	
	@WebMethod
	public String listArticles() 
	{
		try {
			return getArticlesApp().listArticles();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@WebMethod
	public void deleteArticle(String id)
	{
		try {
			getArticlesApp().delete(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
