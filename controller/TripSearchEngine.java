package controller;

import java.awt.EventQueue;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import model.TripSearchCriteria;
import storage.TripDatabaseController;
import view.MainFrame;
import model.Review;
import model.Trip;

public class TripSearchEngine implements TripSearchEngineInterface {

	private TripDatabaseController tripDatabaseController;
	Attribute attribute;

	public TripSearchEngine() {
		this.tripDatabaseController = new TripDatabaseController();

	}

	@Override
	public ArrayList<Trip> search(TripSearchCriteria criteria) {

		// Return an empty list if criteria is impossible
		//if ((criteria.getDateLow() != null) && criteria.getDateLow().after(criteria.getDateHigh())) return new ArrayList<Trip>();
		//if ((criteria.getPriceLow() != null) && criteria.getPriceLow() > criteria.getPriceHigh()) return new ArrayList<Trip>();

		try {
			return this.tripDatabaseController.getTripsByCriteria(criteria);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Trip>();
	}

	@Override
	public ArrayList<Review> findReviews(Trip trip)  {

		// Return an empty list if trip is null
		if (trip == null) return new ArrayList<Review>();
		try {
			return this.tripDatabaseController.getTripReviews(trip.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Review>();
	}

	@Override
	public ArrayList<Trip> sortBy(Attribute attributeToSortBy, ArrayList<Trip> listOfTripsToSort, Boolean ascending) {
		Comparator sortingComparator;
		switch (attributeToSortBy) {
			case PRICE:
				if (ascending) {
					sortingComparator = new Comparator<Trip>() {
						public int compare(Trip t1, Trip t2) {
							if (t1.getPrice() < t2.getPrice()) {
								return -1;
							} else if (t1.getPrice() == t2.getPrice()) {
								return 0;
							} else {
								return 1;
							}
						}
					};
				} else { //!ascending
					sortingComparator = new Comparator<Trip>() {
						public int compare(Trip t1, Trip t2) {
							if (t1.getPrice() > t2.getPrice()) {
								return -1;
							} else if (t1.getPrice() == t2.getPrice()) {
								return 0;
							} else {
								return 1;
							}
						}
					};
				}
				break;
			case DATE:
				if (ascending) {
					sortingComparator = new Comparator<Trip>() {
						public int compare(Trip t1, Trip t2) {
							return t1.getDateOfDeparture().compareTo(t2.getDateOfDeparture());
						}
					};
				} else {
					sortingComparator = new Comparator<Trip>() {
						public int compare(Trip t1, Trip t2) {
							return t2.getDateOfDeparture().compareTo(t1.getDateOfDeparture());
						}
					};
				}
				break;
			default:
				System.err.println("Unsuported attribute to sort by at TripSearchEngine.sortBy");
				return listOfTripsToSort;
		}
		
		Collections.sort(listOfTripsToSort, sortingComparator);
		return listOfTripsToSort;
	}

	@Override
	public ArrayList<Trip> filter(ArrayList<Trip> listOfTripsToFilter, TripSearchCriteria criteria) {
		// Probably left unimplemented
		return null;
	}
	
	/*
	// test sortBy:
	public static void main(String[] args) {
		System.out.println("running Trip SearchEngine!");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripSearchEngine tripSearchEngine = new TripSearchEngine();
					TripSearchCriteria criteria = new TripSearchCriteria();
					ArrayList<Trip> listOfTripsToSort = tripSearchEngine.search(criteria);
					System.out.println("\nunsorted list:");
					for (Trip trip : listOfTripsToSort) {
						System.out.println(trip.getPrice() + "    " + trip.getName() + "    " + trip.getDateOfDeparture());
					}
					
					System.out.println("\nsorted by price (ascending):");
					TripSearchEngine.Attribute attributeToSortBy = TripSearchEngine.Attribute.PRICE;
					ArrayList<Trip> sortedListOfTrips = tripSearchEngine.sortBy(attributeToSortBy, listOfTripsToSort, true);
					for (Trip trip : sortedListOfTrips) {
						System.out.println(trip.getPrice() + "    " + trip.getName() + "    " + trip.getDateOfDeparture());
					}
					
					System.out.println("\nsorted by price (descending):");
					attributeToSortBy = TripSearchEngine.Attribute.PRICE;
					sortedListOfTrips = tripSearchEngine.sortBy(attributeToSortBy, listOfTripsToSort, false);
					for (Trip trip : sortedListOfTrips) {
						System.out.println(trip.getPrice() + "    " + trip.getName() + "    " + trip.getDateOfDeparture());
					}
					
					System.out.println("\nsorted by date (ascending):");
					attributeToSortBy = TripSearchEngine.Attribute.DATE;
					sortedListOfTrips = tripSearchEngine.sortBy(attributeToSortBy, listOfTripsToSort, true);
					for (Trip trip : sortedListOfTrips) {
						System.out.println(trip.getDateOfDeparture() + "    " + trip.getPrice() + "    " + trip.getName());
					}
					
					System.out.println("\nsorted by date (descending):");
					attributeToSortBy = TripSearchEngine.Attribute.DATE;
					sortedListOfTrips = tripSearchEngine.sortBy(attributeToSortBy, listOfTripsToSort, false);
					for (Trip trip : sortedListOfTrips) {
						System.out.println(trip.getDateOfDeparture() + "    " + trip.getPrice() + "    " + trip.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
}


// TripSearchEngine tripSearchEngine = new TripSearchEngine();
// TripSearchCriteria criteria = new TripSearchCriteria();
// ArrayList<Trip> listOfTripsToFilter = tripSearchEngine.search(criteria);