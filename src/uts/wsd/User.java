package uts.wsd;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
	@XmlElement(name = "email")
	private String email;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "password")
	private String password;
	@XmlElement(name = "dob")
	private String dob;
	@XmlElement(name = "biography")
	private String biography;
	
	public User() {
	}
	
	public User(String email, String name, String password, String dob, String biography) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.biography = biography;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
}