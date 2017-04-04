package storage;

import java.util.ArrayList;

import model.Trip;
import model.TripSearchCriteria;

public class TripDatabaseController {
	
	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) {
		return new ArrayList<Trip>();
	}
	
	// Hallgrímur vill breyta getTripsByParameter í getTripsByCriteria, þ.e. henda þessu út:
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray){
		return new ArrayList<Trip>();
	}
	
}