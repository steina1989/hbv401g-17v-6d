package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.TripSearchCriteria;
import storage.TripDatabaseController;
import storage.TripDatabaseControllerMockupHallgrimur;
import model.Review;
import model.Trip;

public class TripSearchEngine implements TripSearchEngineInterface {
	
	private TripDatabaseController tripDatabaseController;
	
	public TripSearchEngine() {
		this.tripDatabaseController = new TripDatabaseControllerMockupHallgrimur();
	}

	@Override
	public ArrayList<Trip> search(TripSearchCriteria criteria) {
		
		
		// Return an empty list if criteria is impossible
		if ((criteria.getDateLow() != null) && criteria.getDateLow().after(criteria.getDateHigh())) return new ArrayList<Trip>();
		if ((criteria.getPriceLow() != null) && criteria.getPriceLow() > criteria.getPriceHigh()) return new ArrayList<Trip>();
		
		try {
			return this.tripDatabaseController.getTripsByCriteria(criteria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return new ArrayList<Trip>();
		}
	}

	@Override
	public ArrayList<Review> findReviews(Trip trip) {
		
		// Return an empty list if trip is null
		if (trip == null) return new ArrayList<Review>();
		
		return this.tripDatabaseController.getTripReviews(trip.getId());
	}

	@Override
	public ArrayList<Trip> sortBy(Attribute attribute, ArrayList<Trip> listOfTripsToSort, Boolean ascending) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Trip> filter(ArrayList<Trip> listOfTripsToFilter, TripSearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
