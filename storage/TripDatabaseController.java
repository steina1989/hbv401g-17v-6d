package storage;

import java.util.ArrayList;

import model.Trip;
import model.TripSearchCriteria;

public class TripDatabaseController {
	
	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) {
		return new ArrayList<Trip>();
	}
	
	// Hallgr�mur vill breyta getTripsByParameter � getTripsByCriteria, �.e. henda �essu �t:
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray){
		return new ArrayList<Trip>();
	}
	
}