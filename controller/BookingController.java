package controller;

import java.util.ArrayList;

import model.Trip;
import storage.BookingDatabaseController;
import storage.TripDatabaseController;
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
		System.out.println("Adding trip to cart: " + trip);
		this.cart.add(trip);
		renderTripsInCart();
	}

	private void renderTripsInCart() 
	{
		this.mainFrame.setCartLabelText(this.cart.size());
	}

	public void enterCheckoutPanelClicked() {
		mainFrame.openCheckOutPanel(this.cart);
	}


}
