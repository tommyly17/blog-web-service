package uts.wsd;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
	@XmlAttribute(name = "id")
	private String id;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "date")
	private String date;
	@XmlElement(name = "author")
	private String author;
	@XmlElement(name = "category")
	private String category;
	@XmlElement(name = "preview")
	private String preview;
	@XmlElement(name = "content")
	private String content;
	
	public Article() {
	}
	
	public Article(String id, String title, String date, String author, String category, String preview, String content) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.author = author;
		this.category = category;
		this.preview = preview;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPreview() {
		return preview;
	}
	
	public void setPreview(String preview) {
		this.preview = preview;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
