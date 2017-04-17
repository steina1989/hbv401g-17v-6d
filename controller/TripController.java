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
		this.searchByFilterPanelCriteria();
		this.applySortingByRadioButtons();
		this.renderTrips();
	}
	
	public void sortClicked()
	{
		this.applySortingByRadioButtons();
		this.renderTrips();
	}
	
	public void enterViewTripsPanelClicked() {
		//searchByFilterPanelCriteria(); // do we really need diz?
		//applySortingByRadioButtons(); // do we really need diz?
		this.openViewTripsPanel();
	}
	
	public void tripSeeMoreClicked(Trip trip)
	{
		ArrayList<Review> reviews = this.tripSearchEngine.findReviews(trip);
		System.out.println("tripSearchEngine returned " + reviews.size() + " reviews for trip:" + trip);
	
		
		this.mainFrame.openTripInfoFrame(trip, reviews);
	}
	
	public void mainFrameInitialised() {
		searchByFilterPanelCriteria();
		applySortingByRadioButtons();
		this.mainFrame.openViewTripsPanel(this.listOfTrips);
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
	}
	 
	// can't this method be private? (HDE)
	public ArrayList<Trip> sortingRequested(ArrayList<Trip> trips, String attribute, boolean ascending)
	{
		if (attribute=="Date") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.DATE, trips, ascending);
		else if (attribute=="Price") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.PRICE, trips, ascending);
		else throw new IllegalArgumentException("Attribute needs to be 'date', or 'price'");
	}
	
	private void renderTrips() {
    this.mainFrame.getViewTripsPanel().setListOfTrips(this.listOfTrips);
	}
	
	private void openViewTripsPanel() {
		this.mainFrame.openViewTripsPanel(this.listOfTrips);
	}
	
	
	
	
	

	
	}
	
	


