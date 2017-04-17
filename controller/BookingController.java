package controller;

import java.util.ArrayList;

import model.Trip;
import view.MainFrame;

public class BookingController {

	private MainFrame mainFrame;
	private ArrayList<Trip> cart;
	private BookingController bookingController;

	public BookingController(MainFrame mf){
		this.mainFrame = mf;
		this.cart = new ArrayList<Trip>();
		this.bookingController = bookingController;
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



}
