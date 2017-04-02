package controller;

import view.FilterPanel;
import view.MainFrame;
import storage.TripDatabaseController;
import view.ListOfTripsPanel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Trip;



public class TripController {
	
	MainFrame mainFrame;
	protected TripDatabaseController tripDatabaseController;
	ArrayList<Trip> listOfTrips;
	
	public TripController() {
		
	}
	
	public TripController(MainFrame mf, TripDatabaseController dbctrl){
		mainFrame = mf;
		tripDatabaseController = dbctrl;
	}
	
	protected void search(ArrayList<String> filterArray)
	{
		if(filterArray.size()!=6) throw new IllegalArgumentException();
		listOfTrips =  tripDatabaseController.getTripsByParameter(filterArray);
	}
	
	
	public void sortByDate(){
		Collections.sort(listOfTrips, new Comparator<Trip>(){
			@Override
			public int compare(Trip t1, Trip t2){
				return t1.getDate().compareTo(t2.getDate());
			}
		});
	}
	
	
	
	public ArrayList<Trip> getListOfTrips() 
	{
		return listOfTrips;
	}

	private ArrayList<String> getFilterArray(FilterPanel fp)
	{
		ArrayList<String> filter = new ArrayList<String>();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		filter.add(fp.getName());
		filter.add(df.format(fp.getDateLow()));
		filter.add(df.format(fp.getDateHigh()));
		filter.add(Integer.toString(fp.getPriceLow()));
		filter.add(Integer.toString(fp.getPriceHigh()));
		filter.add(fp.getCategory());
		
		return filter;
	}
	
	public void searchClicked()
	{
		FilterPanel fp =  ((ListOfTripsPanel) mainFrame.getListOfTripsPanel()).getFilterPanel();
		ArrayList<String> filterArray = getFilterArray(fp); 
		search(filterArray);
	}
	 
	
	protected void setTripDatabaseController(TripDatabaseController tdc)
	{
		this.tripDatabaseController = tdc;
	}
	
	
	}
	
	


