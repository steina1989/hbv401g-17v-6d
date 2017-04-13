package controller;

import java.util.ArrayList;

import model.TripSearchCriteria;
import model.Review;
import model.Trip;

public interface TripSearchEngineInterface {

	// Attribute defines an
	// attribute to sort by
	public enum Attribute {
		NAME,
		DATE,
		PRICE;
	}

	// Returns a list of trips based on criteria
	// see tripSearchEngine.Criteria class
	public ArrayList<Trip> search(TripSearchCriteria criteria);

	// Returns a list of reviews that are associated with trip.
	public ArrayList<Review> findReviews(Trip trip);

	// Returns listOfTripsToSort sorted in ascending order
	// by attributeEnum.
	// attributeEnum is an Attribute defined as follows:
	// private enum Attribute {NAME, DATE, PRICE};
	// if ascending is true the list is sorted in ascending order
	// else it is sorted in descending order.
	public ArrayList<Trip> sortBy(Attribute attribute,
			ArrayList<Trip>listOfTripsToSort,
			Boolean ascending);

	// Returns listOfTripsToFilter filtered by criteria
	// see tripSearchEngine.Criteria class
	// criteria attributres that are null are ignored.
	public ArrayList<Trip> filter(ArrayList<Trip> listOfTripsToFilter,
			TripSearchCriteria criteria);
}