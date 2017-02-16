package uts.wsd;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "articles") 
public class Articles implements Serializable 
{
	@XmlElement(name = "article")
    private ArrayList<Article> list = new ArrayList<Article>();
	
	public Articles() {
	}
 
    public ArrayList<Article> getList() {
        return list;
    }

	public void addArticle(Article article) {
        list.add(article);
    }
    public void removeArticle(Article article) {
        list.remove(article);
    }
    
    public Article getArticle(String id) //returns article based on the id given
    {
        // For each article in the list...
        for (Article article : list) 
        {
            if (article.getId().equals(id))
                return article; // if id matches, return this article
        }
        return null; // no match return null
    }
    
    public Article getLastArticle() { //returns last article in the list
    	int last = list.size() - 1; //Get the size of the list minus one i.e. the last element
    	return list.get(last); //Returns last item in the list
    }

	public void category(String category) 
    {
		ArrayList<Article> temp = new ArrayList<Article>(); //creates temporary list
		for (Article article : list) 
    	{
    		if (article.getCategory().equals(category))
    		{
    			temp.add(article); //if it finds the article with category specified adds to temporarylist
    		}
    	}
		list.clear(); //clears contents of current list
		list.addAll(temp); //adds contents of temporary list to the current list
    }
	
	public void startDate(String date) throws ParseException
	{
		ArrayList<Article> temp = new ArrayList<Article>(); //creates temporary list
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //creates date in format day-month-year
		Date startDate = sdf.parse(date); //parses the date of the string given
		for (Article article : list)
		{
			Date articleDate = sdf.parse(article.getDate());
			if (articleDate.after(startDate)) //if date is after given date
				temp.add(article); //add date to temp list
			else if (articleDate.equals(startDate))
				temp.add(article); //if date is equal given date add to temp list
		}
		list.clear();
		list.addAll(temp);
		
	}
	
	public void endDate(String date) throws ParseException
	{
		ArrayList<Article> temp = new ArrayList<Article>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date endDate = sdf.parse(date);
		for (Article article : list)
		{
			Date articleDate = sdf.parse(article.getDate());
			if (articleDate.before(endDate))
				temp.add(article);
			else if (articleDate.equals(endDate))
				temp.add(article);
		}
		list.clear();
		list.addAll(temp);
	}
	
	public String listArticles() 
	{
		String articleList = "Articles currently posted are:";
		for (Article article : list) 
		{
			articleList += "\n" + "Article ID: " + article.getId() + " | Article Title: " + article.getTitle();
		}
		return articleList;
	}
	
	public void deleteArticle(String id)
	{
		ArrayList<Article> temp = new ArrayList<Article>(); //temp list
		for (Article article : list)
		{
			if (article.getId().equals(id))
				temp.add(article); //if article has same id as date given then add to temp liist
		}
		
		for (Article article : temp)
		{
			list.remove(article); //remove the contents of temp list from the current list
		}
	}
}
