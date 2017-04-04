package model;

import java.util.*;

public class Trip {
	
	private String name;
	private int id;
	private Date dateOfDeparture;
	private Date dateOfReturn;
	private int numberOfReviews;
	private Location location;
	private int price;
	private String description;
	private int seatsAvailable;
	private String category;
	private ArrayList<Guide> guides;
	
	
	
	public Trip(){}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfReviews() {
		return numberOfReviews;
	}
	public void setReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ArrayList<Guide> getGuides() {
		return guides;
	}
	public void setGuides(ArrayList<Guide> guides) {
		this.guides = guides;
	}	
	
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	
	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public void setNumberOfReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public String toString(){
		return "Name: "+ this.name + " Id: " + this.id;
	}

	
	
}
