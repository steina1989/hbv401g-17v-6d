package controller;

import view.FilterPanel;
import view.MainFrame;
import storage.TripDatabaseController;
import storage.TripDatabaseControllerMockup;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Trip;



public class TripController {
	
	MainFrame mainFrame;
	TripDatabaseControllerMockup tripDatabaseController;
	ArrayList<Trip> listOfTrips;
	
	public TripController(MainFrame mf, TripDatabaseController dbctrl){
		mainFrame = mf;
	}
	
	public ArrayList<Trip> search(ArrayList<String> filter){
		
		listOfTrips =  tripDatabaseController.getTripsByParameter(filter);
		
	}

	public ArrayList<Trip> getListOfTrips() {
		return listOfTrips;
	}

	private ArrayList<String> getFilterArray(FilterPanel fp)
	{
		ArrayList<String> filter = new ArrayList<String>();
		DateFormat df = new SimpleDateFormat("MM/dd/yyy");
		
		
		filter.add(fp.getName());
		filter.add(df.format(fp.getDateLow()));
		filter.add(df.format(fp.getDateHigh()));
		filter.add(Integer.toString(fp.getPriceLow()));
		filter.add(Integer.toString(fp.getPriceHigh()));
		filter.add(fp.getCategory());
		
		return filter;
	}
	
	public searchClicked()
	{
		FilterPanel fp = mf.getListOfTripPanel().getFilterPanel();
		ArrayList<String> filterArray = getFilterArray(fp); 
		search(filterArray);
	}

	
		
		
	}
	
	


