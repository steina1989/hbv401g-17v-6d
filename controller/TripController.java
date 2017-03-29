package controller;

import view.FilterPanel;
import view.MainFrame;
import storage.TripDatabaseController;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Trip;



public class TripController {
	
	MainFrame mainFrame;
	TripDatabaseController tripDatabaseController;
	
	public TripController(MainFrame mf, TripDatabaseController dbctrl){
		mainFrame = mf;
		tripDatabaseController = dbctrl;
	}
	
	public ArrayList<Trip> search(FilterPanel fp){
		
		return tripDatabaseController.getTripsByParameter(fp.getDateLow(),fp.getDateHigh());

	}
		
		
	}
	
	


