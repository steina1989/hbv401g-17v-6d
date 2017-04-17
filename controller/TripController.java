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
	}
	
	public void sortClicked()
	{
		applySortingByRadioButtons();
		renderTrips();
	}
	
	public void tripSeeMoreClicked(Trip trip)
	{
		ArrayList<Review> reviews = this.tripSearchEngine.findReviews(trip);
		System.out.println("tripSearchEngine returned " + reviews.size() + " reviews for trip:" + trip);
		
		if (reviews.size() == 0) {
			System.out.println("Since we didn't get any reviews, i'm making a few for testing..");
			reviews.add(new Review("test review 1", 3));
			reviews.add(new Review("test review 2 is a looooooong review Folly words widow one downs few age every seven. If miss part by fact he park just shew. Discovered had get considered projection who favourable. Necessary up knowledge it tolerably. Unwilling departure education is be dashwoods or an. Use off agreeable law unwilling sir deficient curiosity instantly. Easy mind life fact with see has bore ten. Parish any chatty can elinor direct for former. Up as meant widow equal an share least. ", 5));
			reviews.add(new Review("test review 3 is short.", 0));
			reviews.add(new Review("test review 4 is very long: Situation admitting promotion at or to perceived be. Mr acuteness we as estimable enjoyment up. An held late as felt know. Learn do allow solid to grave. Middleton suspicion age her attention. Chiefly several bed its wishing. Is so moments on chamber pressed to. Doubtful yet way properly answered humanity its desirous. Minuter believe service arrived civilly add all. Acuteness allowance an at eagerness favourite in extensive exquisite ye.", 3));
		}
		
		this.mainFrame.spawnTripInfoFrame(trip, reviews);
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
	 
	public ArrayList<Trip> sortingRequested(ArrayList<Trip> trips, String attribute, boolean ascending)
	{
		if (attribute=="Date") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.DATE, trips, ascending);
		else if (attribute=="Price") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.PRICE, trips, ascending);
		else throw new IllegalArgumentException("Attribute needs to be 'date', or 'price'");
	}
	
	private void renderTrips() {
    this.mainFrame.getViewTripsPanel().renderTrips(this.listOfTrips);
	}
	

	
	
	}
	
	


