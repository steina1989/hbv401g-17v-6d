package unitTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.TripController;
import model.*;


public class TripControllerTest extends TripController {

	String[] legalParameters;
	String[] illegalParameters;

	

	@Before
	public void setUp() throws Exception {
		//The legal parameter will be set with TripController functions with further development.
		legalParameters = new String[6]; 
		illegalParameters = new String[5];
		//setTripDatabaseController not used in setup since we refer to different mockupObjects in the tests.
	}

	@After
	public void tearDown() throws Exception{
		this.setTripDatabaseController(null);
		legalParameters = null;
		illegalParameters = null;
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

