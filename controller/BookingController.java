package controller;

import java.util.ArrayList;

import model.Trip;
import storage.BookingDatabaseController;
import storage.TripDatabaseController;
import view.CheckoutPanel;
import view.MainFrame;

public class BookingController {

	private MainFrame mainFrame;
	private ArrayList<Trip> cart;
	private TripDatabaseController bookingDatabaseController;

	public BookingController(MainFrame mf){
		this.mainFrame = mf;
		this.cart = new ArrayList<Trip>();

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
	
	private int getSelectedTripIndex() {
		CheckoutPanel checkoutPanel = this.mainFrame.getViewBookingsPanel().getCheckoutPanel();
		return checkoutPanel.getTripsInCartJList().getSelectedIndex();
	}
}
