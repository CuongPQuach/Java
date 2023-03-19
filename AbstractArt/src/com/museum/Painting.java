package com.museum;

public class Painting extends Art{
	private String painType;

		
//	contructor 
	public Painting(String title, String author, String description , String painType)
	{
		this.title = title;
		this.author = author;
		this.description = description;
		this.painType = painType;
		
	}

	
	
	
	
	
	
	
	public String getPainType() {
		return painType;
	}

	public void setPainType(String painType) {
		this.painType = painType;
	}
	
	public void viewArt() {
		System.out.printf("I see Painting! Its %s \n",this.title);
	}
}
