package com.museum;

public abstract class Art {
	protected String title;
	protected String author;
	protected String description;
	
	
	
	public abstract void viewArt();
	
	
	
//	getter and setter
	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getArthour() {
		return author;
	}




	public void setArthour(String author) {
		this.author = author;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}





}
