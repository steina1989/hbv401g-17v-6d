package storage;

import java.util.ArrayList;

import model.Review;
import model.Trip;
import model.TripSearchCriteria;

public class TripDatabaseController {
	
	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) {
		// this function will need some super-powers from �li
		return new ArrayList<Trip>();
	}
	
	public ArrayList<Review> getTripReviews(int tripID) {
		// this function will need some super-powers from �li
		return new ArrayList<Review>();
	}
	
	// Hallgr�mur vill henda �essu falli, �.e. nota frekar / kalla �a� getTripsByCriteria
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray){
		return new ArrayList<Trip>();
	}
	
}