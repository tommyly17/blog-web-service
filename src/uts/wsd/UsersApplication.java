package uts.wsd;

import java.io.*;

import javax.xml.bind.*;

public class UsersApplication {
	private String filePath;
	private Users users;
	
	public void setFilePath(String filePath) throws JAXBException, IOException
	{
		this.filePath = filePath;

		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		 
		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users)u.unmarshal(fin); // This loads the "users" object into field
		fin.close();
	}
	
	public void unmarshal(String filePath) throws JAXBException, IOException
	{
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		 
		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users)u.unmarshal(fin); // This loads the "users" object into field
		fin.close();
	}
	
	public void marshal(Users users, String filePath) throws JAXBException, FileNotFoundException
	{
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='users.xsl' ?>");
		m.marshal(users, new FileOutputStream(filePath)); 
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getFilePath() {
		return filePath;
	}
}