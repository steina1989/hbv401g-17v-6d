package model;

import java.util.*;

public class Trip {
	
	private String name;
	private int id;
	private Date dateOfDeparture;
	private Date dateOfReturn;
	private Location location;
	private int price;
	private String description;
	private int seatsAvailable;
	private String category;
	private ArrayList<Guide> guides;
	
	
	
	public Trip(String name, int id, Date dateOfDeparture, Date dateOfReturn, Location location, int price,
			String description, int seatsAvailable, String category, ArrayList<Guide> guides) {
		super();
		this.name = name;
		this.id = id;
		this.dateOfDeparture = dateOfDeparture;
		this.dateOfReturn = dateOfReturn;
		this.location = location;
		this.price = price;
		this.description = description;
		this.seatsAvailable = seatsAvailable;
		this.category = category;
		this.guides = guides;
	}
	
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


	@Override
	public String toString(){
		return "Name: "+ this.name + " Id: " + this.id;
	}

	
	
}
