package controller;

import view.FilterPanel;
import view.MainFrame;
import view.ViewTripsPanel;

import java.util.ArrayList;
import model.Review;
import model.Trip;


public class TripController {
	
	MainFrame mainFrame;
	TripSearchEngine tripSearchEngine;
	ArrayList<Trip> listOfTrips;
	
	
	public TripController(MainFrame mf){
		mainFrame = mf;
		tripSearchEngine = new TripSearchEngine();
	}
		
	
	public ArrayList<Trip> getListOfTrips() 
	{
		return listOfTrips;
	}
	
	public void searchClicked()
	{
		FilterPanel fp = mainFrame.getViewTripsPanel().getFilterPanel();
		listOfTrips = tripSearchEngine.search(fp.getCriteria());
	}
	
	//Reviews need to be fetched separately when a user selects a trip to examine it in detail (in TripInfoFrame)
	public ArrayList<Review> tripFromListClicked(Trip trip){
		return tripSearchEngine.findReviews(trip);
	}
	 
	public ArrayList<Trip> sortingRequested(ArrayList<Trip> trips, String attribute, boolean ascending)
	{
		if (attribute=="name") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.NAME, trips, ascending);
		else if (attribute=="date") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.DATE, trips, ascending);
		else if (attribute=="price") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.PRICE, trips, ascending);
		else throw new IllegalArgumentException("Attribute needs to be 'name', 'date', or 'price'");
	}

	
	}
	
	


