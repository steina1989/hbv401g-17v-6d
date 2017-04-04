package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.TripSearchEngine;
import model.Trip;
import model.TripSearchCriteria;
import storage.TripDatabaseControllerMockupEmpty;

public class TripControllerTestHallgrimur {
	
	private TripSearchEngine tripSearchEngine;
	private TripSearchCriteria criteria;
	private ArrayList<Trip> searchResults;

	@Before
	public void setUp() throws Exception {
		tripSearchEngine = new TripSearchEngine();
		criteria = new TripSearchCriteria();
		searchResults = new ArrayList<Trip>();
	}

	@After
	public void tearDown() throws Exception {
		tripSearchEngine = null;
		criteria = null;
		searchResults = null;
	}
	
	// if criteria.dateLow > criteria.dateHigh search should return empty list.
	@Test
	public void searchReturnsEmptyListOnOverclampedDates() {

		//
		// create dateLow, dateHigh here
		// and let dateLow > dateHigh
		//
		this.criteria.setDateLow(dateLow);
		this.criteria.setDateHigh(dateHigh);

		this.searchResults = this.tripSearchEngine.search(criteria);
		
		// did we get an empty ArrayList?
		assertEquals(true, this.searchResults instanceof ArrayList<?>);
		assertEquals(0, this.searchResults.size());
	}
	
	// if criteria.priceLow > criteria.priceHigh search should return empty list
	@Test
	public void searchReturnsEmptyListOnOverclampedPrices() {
		this.criteria.setPriceLow(1000);
		this.criteria.setPriceHigh(950);
		
		this.searchResults = this.tripSearchEngine.search(criteria);
		
		// did we get an empty ArrayList?
		assertEquals(true, this.searchResults instanceof ArrayList<?>);
		assertEquals(0, this.searchResults.size());
	}

	@Test
	public void searchReturnsEmptyList() {
		TripDatabaseControllerMockupEmpty tripDatabaseController = new TripDatabaseControllerMockupEmpty();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList(legalParameters)));
		assertEquals(true,this.getListOfTrips() instanceof ArrayList<?>);
		assertEquals(0,this.getListOfTrips().size());
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void filterParameterShort()
	{
		TripDatabaseControllerMockupNotEmptyList tripDatabaseController = new TripDatabaseControllerMockupNotEmptyList();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList(illegalParameters)));
	}

	
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
			
}

