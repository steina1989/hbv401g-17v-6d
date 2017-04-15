package model;


public class Booking {

	private String buyer;
	private int bookingId;
	private int trip;
	private int numberOfGuests;
	private int phoneOfBuyer;
	private String emailOfBuyer;
	
	public Booking(Integer bookingId, Integer trip, Integer numberOfGuests, String comment, Integer phoneOfBuyer, String emailOfBuyer) {
		super();
		this.bookingId = bookingId;
		this.trip = trip;
		this.numberOfGuests = numberOfGuests;
		this.phoneOfBuyer = phoneOfBuyer;
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
