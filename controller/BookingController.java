package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Booking;
import model.Trip;
import storage.BookingDatabaseController;
import storage.TripDatabaseController;
import view.BookingInfoPanel;
import view.CheckoutPanel;
import view.MainFrame;

public class BookingController {

	private MainFrame mainFrame;
	private ArrayList<Trip> cart;
	private BookingDatabaseController bookingDatabaseController;

	public BookingController(MainFrame mf){
		this.mainFrame = mf;
		this.cart = new ArrayList<Trip>();
		
		this.bookingDatabaseController = new BookingDatabaseController();
	}


	public void addToCartClicked(Trip trip) {
		if (!tripExistsInCart(trip)) {
			System.out.println("Adding trip to cart: " + trip);
			this.cart.add(trip);
			refreshTripsInCartLabel();
		}
	}

	public void enterViewBookingsPanelClicked() {
		mainFrame.openCheckOutPanel(this.cart);
	}
	
	public void tripsInCartJListClicked() {
		this.updateCancelTripButton();
	}
	
	public void cancelTripButtonClicked() {
		int selectedTripIndex = this.getSelectedTripIndex();
		if (selectedTripIndex >= 0) {
			this.cart.remove(selectedTripIndex);
			refreshTripsInCartJList();
			refreshTripsInCartLabel();
			refreshCancelTripButton();
		}
	}
	
	public void confirmBookingClicked() {
		ArrayList<Booking> bookings = createBookingsFromBookingInfoPanel();
		
		for (Booking booking : bookings) {
			if (!seatsAvailableOK(booking)) {
				updateViewWithBookingFailed();
				return;
			}
		}
		
		setBookings(bookings);
		
		updateViewWithBookingCompleted();
	}
	
	private void setBookings(ArrayList<Booking> bookings) {
		for (Booking booking : bookings) {
			try {
				this.bookingDatabaseController.setUserBookings(booking);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void updateViewWithBookingFailed() {
		BookingInfoPanel bookingInfoPanel = this.mainFrame.getViewBookingsPanel().getBookingInfoPanel();
		
		bookingInfoPanel.setBookingSucessfulLabelColorRed();
		bookingInfoPanel.setBookingSuccessfulLabel("Not enough seats available");
	}
	
	private void updateViewWithBookingCompleted() {
		BookingInfoPanel bookingInfoPanel = this.mainFrame.getViewBookingsPanel().getBookingInfoPanel();
		
		bookingInfoPanel.clearFillOutText();
		bookingInfoPanel.setBookingSucessfulLabelColorGreen();
		bookingInfoPanel.setBookingSuccessfulLabel("Booking successful");
	}

	private boolean tripExistsInCart(Trip candidate) {
		for (Trip trip : this.cart) {
			if (trip.getId() == candidate.getId()) {
				return true;
			}
		}
		return false;
	}
	
	private void updateCancelTripButton() {
		int selectedTripIndex = this.getSelectedTripIndex();
		this.refreshCancelTripButton();
	}

	private void refreshTripsInCartLabel() 
	{
		this.mainFrame.setCartLabelText(this.cart.size());
	}
	
	private void refreshTripsInCartJList() {
		this.mainFrame.getViewBookingsPanel().setTrips(this.cart);
	}
	
	private void refreshCancelTripButton() {
		if (this.getSelectedTripIndex() >= 0) {
			this.mainFrame.getViewBookingsPanel().getCheckoutPanel().getCancelTripButton().setEnabled(true);
		} else {
			this.mainFrame.getViewBookingsPanel().getCheckoutPanel().getCancelTripButton().setEnabled(false);
		}
	}
	
	private ArrayList<Booking> createBookingsFromBookingInfoPanel() {
		BookingInfoPanel bip = this.mainFrame.getViewBookingsPanel().getBookingInfoPanel();
		ArrayList<Booking> listOfBookings = new ArrayList<Booking>();
		for (Trip trip : cart)
		{
			Booking booking = new Booking(trip.getId(),bip.getNumberOfGuests(), bip.getNameOfBuyer(), bip.getPhoneOfBuyer(),bip.getEmailOfBuyer());
			listOfBookings.add(booking);
		}
		return listOfBookings;
	}
	
	private boolean seatsAvailableOK(Booking booking) {
		int tripId = booking.getTripId();
		int numOfGuests = booking.getNumberOfGuests();
		try {
			return bookingDatabaseController.seatsAvailableOK(tripId, numOfGuests);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	private int getSelectedTripIndex() {
		CheckoutPanel checkoutPanel = this.mainFrame.getViewBookingsPanel().getCheckoutPanel();
		return checkoutPanel.getTripsInCartJList().getSelectedIndex();
	}
}
