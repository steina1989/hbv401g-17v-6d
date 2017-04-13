package controller;

import view.FilterPanel;
import view.MainFrame;
import java.util.ArrayList;
import model.Review;
import model.Trip;


public class TripController {
	
	MainFrame mainFrame;
	TripSearchEngine tripSearchEngine;
	ArrayList<Trip> listOfTrips;
	
	
	public TripController(MainFrame mf){
		mainFrame = mf;
	}
		

	
	
	public ArrayList<Trip> getListOfTrips() 
	{
		return listOfTrips;
	}
	
	public void searchClicked()
	{
		FilterPanel fp = (FilterPanel) mainFrame.getFilterPanel();
		tripSearchEngine.search(fp.getCriteria());
	}
	
	//Reviews need to be fetched seperately when a user selects a trip to examine it in detail (in TripInfoFrame)
	public ArrayList<Review> tripOpened(Trip trip){
		return tripSearchEngine.findReviews(trip);
	}
	 

	
	}
	
	


