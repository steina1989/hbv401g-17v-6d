package controller;

import java.util.ArrayList;

import model.TripSearchCriteria;
import storage.TripDatabaseController;
import model.Review;
import model.Trip;

public class TripSearchEngine implements TripSearchEngineInterface {
	
	private TripDatabaseController tripDatabaseController;
	
	public TripSearchEngine() {
		this.tripDatabaseController = new TripDatabaseController();
	}

	@Override
	public ArrayList<Trip> search(TripSearchCriteria criteria) {
		
		// *******
		// * check to see if all criteria.atributes are valid
		// * they have some correct format but can alse be null
		// * like criteria.lowDate has to be either on the correct date format
		// * or null.
		// *******
		
		return this.tripDatabaseController.getTripsByCriteria(criteria);
	}

	@Override
	public ArrayList<Review> findReviews(Trip trip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trip> sortBy(ArrayList<Trip> listOfTripsToSort, Enum attribute, Boolean ascending) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trip> filter(ArrayList<Trip> listOfTripsToFilter, TripSearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
