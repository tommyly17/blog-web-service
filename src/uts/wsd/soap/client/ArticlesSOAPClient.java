package uts.wsd.soap.client;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBException;
import javax.xml.rpc.ServiceException;

import java.util.*;

public class ArticlesSOAPClient {
	public static void main(String[] args) throws ServiceException, JAXBException, IOException, RemoteException
	{
		ArticlesSOAPServiceLocator locator = new ArticlesSOAPServiceLocator();
		ArticlesSOAP articles = locator.getArticlesSOAPPort();
		
		//code goes below here
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a command: ");
		String command = keyboard.nextLine();
		while (!command.equals("exit"))
		{
			switch (command)
			{
				case "list": System.out.println(articles.listArticles()); break;
				case "delete": 
				{
					System.out.print("Please enter ID of the article you would like to delete: ");
					String id = keyboard.nextLine();
					articles.deleteArticle(id);
					break;
				}
				case "exit": System.exit(0);
				default: System.out.println("Commands are 'list' or 'delete' or 'exit'");
			}
			
			System.out.print("Please enter a command: ");
			command = keyboard.nextLine();
		}
	}
}
