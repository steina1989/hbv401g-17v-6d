package model;

import java.util.*;

public class Trip {
	
	private String name;
	private int id;
	private Date dateOfDeparture;
	private Date dateOfReturn;
	private int price;
	private String description;
	private int seatsAvailable;
	private int seatsLeft;
	private String category;
	private Guide guide;
	private String placeOfDeparture;
	private String placeOfArrival;
	private int duration; // minutes
	private int meanRating;
	private int noReviews;
	
	
	public Trip(String name, int id, Date dateOfDeparture, Date dateOfReturn, int price,
			String description, int seatsAvailable, int seatsLeft, String category, Guide guide, int meanRating, int noReviews) {
		super();
		this.name = name;
		this.id = id;
		this.dateOfDeparture = dateOfDeparture;
		this.dateOfReturn = dateOfReturn;
		this.price = price;
		this.description = description;
		this.seatsAvailable = seatsAvailable;
		this.seatsLeft = seatsLeft;
		this.category = category;
		this.guide = guide;
		this.meanRating = meanRating;
		this.noReviews = noReviews;
	}
	
	
	
	public int getMeanRating() {
		return meanRating;
	}



	public void setMeanRating(int meanRating) {
		this.meanRating = meanRating;
	}



	public int getNoReviews() {
		return noReviews;
	}



	public void setNoReviews(int noReviews) {
		this.noReviews = noReviews;
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
	public Guide getGuide() {
		return guide;
	}
	public void setGuides(Guide guide) {
		this.guide = guide;
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
		return "Name: "+ this.name + " Departure: "+this.getDateOfDeparture().toString()+"Price: "+Integer.toString(this.price);
	}



	public int getSeatsLeft() {
		return seatsLeft;
	}



	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}



	public String getPlaceOfDeparture() {
		return placeOfDeparture;
	}



	public void setPlaceOfDeparture(String placeOfDeparture) {
		this.placeOfDeparture = placeOfDeparture;
	}



	public String getPlaceOfArrival() {
		return placeOfArrival;
	}



	public void setPlaceOfArrival(String placeOfArrival) {
		this.placeOfArrival = placeOfArrival;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	
}
