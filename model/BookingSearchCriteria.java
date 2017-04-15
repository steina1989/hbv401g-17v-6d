package model;

import java.util.Date;

public class BookingSearchCriteria {

	private String buyer;
	private int bookingId;
	private int trip;
	private int numberOfGuests;
	private int phoneOfBuyer;
	private String emailOfBuyer;
	
	public BookingSearchCriteria() {
	  	this.bookingId = 0;
	  	this.trip = 0; //lowDate is current time (a timestamp basically)
	  	this.numberOfGuests = 0;
	  	this.phoneOfBuyer = 8768788;
	  	this.emailOfBuyer = "";
	  }
	public BookingSearchCriteria(Integer bookingId, Integer trip, Integer numberOfGuests, String comment, Integer phoneOfBuyer, String emailOfBuyer) {
		super();
		this.bookingId = bookingId;
		this.trip = trip;
		this.numberOfGuests = numberOfGuests;
		this.emailOfBuyer = emailOfBuyer;
	}
	
	
	public String getEmailOfBuyer() {
		return emailOfBuyer;
	}
	public void setEmailOfBuyer(String emailOfBuyer) {
		this.emailOfBuyer = emailOfBuyer;
	}
	public int getPhoneOfBuyer() {
		return phoneOfBuyer;
	}
	public void setPhoneOfBuyer(int phoneOfBuyer) {
		this.phoneOfBuyer = phoneOfBuyer;
	}
	
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getTrip() {
		return trip;
	}
	public void setTrip(int trip) {
		this.trip = trip;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	
	
}
