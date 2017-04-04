package controller;

import java.util.ArrayList;

import model.TripSearchCriteria;
import model.Review;
import model.Trip;

public interface TripSearchEngineInterface {
	 
  // Returns a list of trips based on criteria
  // see tripSearchEngine.Criteria class
  // criteria attributes that are null are ignored.
  public ArrayList<Trip> search(TripSearchCriteria criteria);
 
  // Returns a list of reviews that are associated with trip.
  public ArrayList<Review> findReviews(Trip trip);
 
  // Returns listOfTripsToSort sorted in ascending order
  // by attributeEnum.
  // attributeEnum is an Attribute defined as follows:
  // private enum Attribute {NAME, DATE, PRICE};
  // if ascending is true the list is sorted in ascending order
  // else it is sorted in descending order.
  public ArrayList<Trip> sortBy(ArrayList<Trip>listOfTripsToSort,
                                         Enum attribute, Boolean ascending);
 
  // Returns listOfTripsToFilter filtered by criteria
  // see tripSearchEngine.Criteria class
  // criteria attributres that are null are ignored.
  public ArrayList<Trip> filter(ArrayList<Trip> listOfTripsToFilter,
                                TripSearchCriteria criteria);
}