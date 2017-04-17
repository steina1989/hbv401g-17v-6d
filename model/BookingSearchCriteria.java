package model;



public class BookingSearchCriteria {

	
	private int bookingId;
	private int trip;
	private int numberOfGuests;
	private String nameOfBuyer;
	private int phoneOfBuyer;
	private String emailOfBuyer;
	
	public BookingSearchCriteria() {
	  	this.bookingId = 0;
	  	this.trip = 0; 
	  	this.numberOfGuests = 0;
	  	this.nameOfBuyer="";
	  	this.phoneOfBuyer = 0;
	  	this.emailOfBuyer = "";
	  }
	public BookingSearchCriteria(Integer bookingId, Integer trip, Integer numberOfGuests, String comment, Integer phoneOfBuyer, String emailOfBuyer) {
		super();
		this.bookingId = bookingId;
		this.trip = trip;
		this.numberOfGuests = numberOfGuests;
		this.emailOfBuyer = emailOfBuyer;
	}
	


	public String getNameOfBuyer() {
		return nameOfBuyer;
	}
	public void setNameOfBuyer(String nameOfBuyer) {
		this.nameOfBuyer = nameOfBuyer;
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
