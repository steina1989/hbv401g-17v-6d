package model;
import java.util.Date;

public class Booking {

	private Buyer buyer;
	private int bookingId;
	private Trip trip;
	private int numberOfGuests;
	private Date timeOfBooking;
	private String comment;
	
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	public Date getTimeOfBooking() {
		return timeOfBooking;
	}
	public void setTimeOfBooking(Date timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	

}
