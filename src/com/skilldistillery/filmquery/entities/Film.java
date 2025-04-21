package com.skilldistillery.filmquery.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Film {
	
	//fileds
	private int id;
	private String title;
	private String Description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private List<Category> categories;
	
	//no arg constructor
	public Film () {
		super();
	}
	
	
	//get/set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String eRating) {
		rating = eRating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=").append(id).append(", title=").append(title).append(", Description=")
				.append(Description).append(", releaseYear=").append(releaseYear).append(", languageId=")
				.append(languageId).append(", rentalDuration=").append(rentalDuration).append(", rentalRate=")
				.append(rentalRate).append(", length=").append(length).append(", replacementCost=")
				.append(replacementCost).append(", rating=").append(rating).append(", specialFeatures=")
				.append(specialFeatures).append(", actors : \n").append(listOfActors())
				.append("]");
		
		return builder.toString();
	}
	
	public String listOfActors() {
		StringBuilder builder = new StringBuilder();
		
		for(Actor a:this.actors) {
			builder.append(a.getFirstName())
			.append(" ")
			.append(a.getLastName())
			.append("\n");
		}
		
		return builder.toString();
		
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public String getCategoriesList() {
		StringBuilder builder = new StringBuilder();
		
		for(Category c:this.categories) {
			builder.append(c.getName()).append(" ");
		}
		
		return builder.toString();
	}
	
}
