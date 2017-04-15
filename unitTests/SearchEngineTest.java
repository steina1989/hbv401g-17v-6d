package unitTests;

import static org.junit.Assert.*;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.TripSearchEngine;
import model.Guide;
import model.Review;
import model.Trip;
import model.TripSearchCriteria;

public class SearchEngineTest {
	
	private TripSearchEngine tripSearchEngine;
	private TripSearchCriteria criteria;
	private ArrayList<Trip> searchResults;
	private ArrayList<Review> tripReviews;
	private Trip trip;

	@Before
	public void setUp() throws Exception {
		this.tripSearchEngine = new TripSearchEngine();
		
		// create an example criteria
		this.criteria = new TripSearchCriteria();
		this.criteria.setName("tripName");
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		this.criteria.setDateLow(dateFormat.parse("2016-12-24"));
		this.criteria.setDateHigh(dateFormat.parse("2017-01-01"));
		this.criteria.setPriceLow(500);
		this.criteria.setPriceHigh(10000);
		
		this.searchResults = new ArrayList<Trip>();
		
		// create an example trip
		Date exampleDate1 = this.criteria.getDateLow(); // we just need any Date
		Date exampleDate2 = this.criteria.getDateHigh(); // we just need any Date
		this.trip = new Trip("Golden Circle", 3, exampleDate1, exampleDate2, 1500,
				"https://www.youtube.com/watch?v=WNmCm4oyrkY", 25, 18, "Safari", new Guide("jón", "stóri", new URL("jon.stori.is")), 3, 5);
		
		this.tripReviews = new ArrayList<Review>();
	}

	@After
	public void tearDown() throws Exception {
		this.tripSearchEngine = null;
		this.criteria = null;
		this.searchResults = null;
		this.tripReviews = null;
		this.trip = null;
	}
	
	// search(criteria)
	// returns a list of trips
	@Test
	public void searchReturnsAList() {
		this.tripSearchEngine.search(this.criteria);
		assertTrue(this.searchResults instanceof ArrayList<?>);
	}
	
	// if criteria.dateLow > criteria.dateHigh
	// search(criteria) should return empty list.
	@Test
	public void searchReturnsEmptyListOnOverclampedDates() {

		// create dateLow, dateHigh
		// and let dateLow > dateHigh
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		Date dateLow = new Date();
		Date dateHigh = new Date();
		try {
			dateLow = dateFormat.parse("2017-01-01");
			dateHigh = dateFormat.parse("2016-12-24");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.criteria.setDateLow(dateLow);
		this.criteria.setDateHigh(dateHigh);

		this.searchResults = this.tripSearchEngine.search(this.criteria);
		
		// did we get an empty ArrayList?
		assertTrue(this.searchResults instanceof ArrayList<?>);
		assertEquals(0, this.searchResults.size());
	}
	
	// if criteria.priceLow > criteria.priceHigh
	// search(criteria) should return empty list
	@Test
	public void searchReturnsEmptyListOnOverclampedPrices() {
		this.criteria.setPriceLow(1000);
		this.criteria.setPriceHigh(950);
		
		this.searchResults = this.tripSearchEngine.search(this.criteria);
		
		// did we get an empty ArrayList?
		assertTrue(this.searchResults instanceof ArrayList<?>);
		assertEquals(0, this.searchResults.size());
	}
	
	// if every attribute of criteria is null
	// search(criteria) should return a list.
	// (the list will contain every trip in the database)
	@Test
	public void searchReturnsListIfNoCriterias() {
		this.criteria = new TripSearchCriteria(); //Criteras are empty.
		this.searchResults = this.tripSearchEngine.search(this.criteria);
		assertTrue(this.searchResults instanceof ArrayList<?>);
	}
	
	// findReviews(trip)
	// returns a list of reviews
	@Test
	public void findReviewsReturnsAList() {
		this.tripReviews = this.tripSearchEngine.findReviews(this.trip);
		assertTrue(this.searchResults instanceof ArrayList<?>);
		assertEquals(2, this.tripReviews.size());
	}
	
	// if trip is null
	// findReviews(trip) should return
	// an empty list of reviews
	@Test
	public void findReviewsReturnsEmptyListOnNullTrip() {
		this.trip = null;
		this.tripReviews = this.tripSearchEngine.findReviews(this.trip);
		
		// did we get an empty ArrayList?
		assertTrue(this.tripReviews instanceof ArrayList<?>);
		assertEquals(0, this.tripReviews.size());
	}
	
	// sortBy(attribute, listOfTripsToSort, ascending)
	// returns a list sorted by attribute
	@Test(expected=UnsupportedOperationException.class)
	public void sortByReturnsSortedListByAttribute() {
		// this test needs to be implemented!
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	// if ascending is true
	// sortBy(attribute, listOfTripsToSort, ascending)
	// should return a list of trips sorted in
	// ascending order by attribute
	@Test(expected=UnsupportedOperationException.class)
	public void sortByAscendingReturnsAscendingSortedList() {
		// this test needs to be implemented!
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	// if ascending is false
	// sortBy(attribute, listOfTripsToSort, ascending)
	// should return a list of trips sorted in
	// descending order by attribute
	@Test(expected=UnsupportedOperationException.class)
	public void sortByAscendingReturnsDescendingSortedList() {
		// this test needs to be implemented!
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	@Test
	public void searchReturnsSortedTripList() {
		
	}
	
	// 
	
	/*
	//Mockup object contains 2 trips in descending order before its sorted.
	@Test 
	public void checkIfSortsByDate()
	{
		TripDatabaseControllerMockupNotEmptyList tripDatabaseController = new TripDatabaseControllerMockupNotEmptyList();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList(legalParameters)));
		this.sortByDate();
		ArrayList<Trip> trips = this.getListOfTrips();
		assertTrue(trips.get(0).getDate().compareTo(trips.get(1).getDate()) < 0);			
	}
	*/
			
}

