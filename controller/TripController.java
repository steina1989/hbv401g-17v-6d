package controller;

import view.FilterPanel;
import view.MainFrame;
import view.ViewTripsPanel;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

import model.Review;
import model.Trip;
import model.TripSearchCriteria;


public class TripController {
	
	private MainFrame mainFrame;
	private TripSearchEngine tripSearchEngine;
	private ArrayList<Trip> listOfTrips;
	private ArrayList<Trip> cart;
	
	
	public TripController(MainFrame mf){
		this.mainFrame = mf;
		this.tripSearchEngine = new TripSearchEngine();
		this.cart = new ArrayList<Trip>();
	}
		
	
	public ArrayList<Trip> getListOfTrips() 
	{
		return listOfTrips;
	}
	
	public void searchClicked()
	{
		searchByFilterPanelCriteria();
		applySortingByRadioButtons();
		renderTrips();
		printTripsInCart();
	}
	
	public void sortClicked()
	{
		applySortingByRadioButtons();
		renderTrips();
	}
	
	public void addToCartClicked(Trip trip) {
		System.out.println("Adding trip to cart: " + trip);
		this.cart.add(trip);
		renderTripsInCart();
	}
	
	private void searchByFilterPanelCriteria() {
		ViewTripsPanel viewTripsPanel = mainFrame.getViewTripsPanel();
		FilterPanel fp = viewTripsPanel.getFilterPanel();
		TripSearchCriteria criteria = fp.getCriteria();
		this.listOfTrips = tripSearchEngine.search(criteria);
	}
	
	private void applySortingByRadioButtons() {
		ViewTripsPanel view = mainFrame.getViewTripsPanel();
		this.listOfTrips = sortingRequested(this.listOfTrips, view.getAttributeToSortBy(), view.getSortingDirection());
		//TripSearchEngine.Attribute attributeToSortBy;
		//if (Objects.equals(viewTripsPanel.getAttributeToSortBy(), "Price")) {
		//	attributeToSortBy = TripSearchEngine.Attribute.PRICE;
		//} else {
		//	attributeToSortBy = TripSearchEngine.Attribute.DATE;
		//}
		//Boolean sortAscending = viewTripsPanel.getSortingDirection();
		//this.listOfTrips = tripSearchEngine.sortBy(attributeToSortBy, this.listOfTrips, sortAscending);
	}
	 
	public ArrayList<Trip> sortingRequested(ArrayList<Trip> trips, String attribute, boolean ascending)
	{
		if (attribute=="Date") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.DATE, trips, ascending);
		else if (attribute=="Price") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.PRICE, trips, ascending);
		else throw new IllegalArgumentException("Attribute needs to be 'date', or 'price'");
	}
	
	private void renderTrips() {
    this.mainFrame.getViewTripsPanel().renderTrips(listOfTrips);
	}
	
	
	private void renderTripsInCart() {
		this.mainFrame.setCartLabelText(this.cart.size());
	}
	
	private void printTripsInCart() {
		System.out.println("Trips currently in cart:");
		for (Trip trip : cart) {
			System.out.println("    " + trip);
		}
	}

	
	}
	
	


