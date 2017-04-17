package model;


public class Booking {

	private String buyer;
	private int bookingId;
	private int tripId;
	private String nameOfBuyer;
	private int numberOfGuests;
	private int phoneOfBuyer;
	private String emailOfBuyer;
	
	public Booking(Integer tripId, Integer numberOfGuests, String nameOfBuyer, Integer phoneOfBuyer, String emailOfBuyer) {
		super();
		this.tripId = tripId;
		this.numberOfGuests = numberOfGuests;
		this.nameOfBuyer = nameOfBuyer;
		this.phoneOfBuyer = phoneOfBuyer;
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
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int trip) {
		this.tripId = trip;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	
	
	
	

}
