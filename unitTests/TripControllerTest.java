package unitTests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.TripController;
import storage.TripDatabaseControllerMockupCategorySkiing;
import storage.TripDatabaseControllerMockupEmpty;
import storage.TripDatabaseControllerMockupNotEmptyList;
import model.*;

/*
Prufum search aðferðina()
Það skilar List of trips.
Test: Skilar alltaf lista, jafnvel tómum.
Test: Ferðir aldrei með 0 eða neikvæð sæti
Test: Skilar réttum tögum.
Test: Mötum db með parameter t.d. Skíðferð. Skoðum svo hvort == skíðaferð.

Erum mest að athuga með validation á input drasli áður en við köllum á getTripsby.....
Testum filterfylkið.

Search kallar á getTripsByParameter sem skilar lista, tripctrller(enn inní search fallinu)
 notar þann lista til að uppfæra ListOfTripsPanel


*/

public class TripControllerTest extends TripController {


	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception{
		
	}

	@Test
	public void searchReturnsEmptyList() {
		TripDatabaseControllerMockupEmpty tripDatabaseController = new TripDatabaseControllerMockupEmpty();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList("tripName", "02/11/2017", "03/30/2017", "500", "490", "skiing")));
		assertEquals(true,this.getListOfTrips() instanceof ArrayList<?>);
		assertEquals(0,this.getListOfTrips().size());
	}
	
	@Test
	public void checkTypes(){
		TripDatabaseControllerMockupNotEmptyList tripDatabaseController = new TripDatabaseControllerMockupNotEmptyList();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList("tripName", "02/11/2017", "03/30/2017", "500", "490", "skiing")));
		ArrayList<Trip> trips = this.getListOfTrips();
		for(Trip trip : trips)
		{
			assertTrue(trip instanceof Trip);
			assertTrue(trip.getName() instanceof String);
			assertTrue(trip.getId() == (int)trip.getId() );
			assertTrue(trip.getDate() instanceof Date);
			assertTrue(trip.getReviews() instanceof ArrayList<?>);
			assertTrue(trip.getLocation() instanceof Location);
			assertTrue(trip.getPrice() == (int)trip.getPrice());
			assertTrue(trip.getDescription() instanceof String);
			assertTrue(trip.getSeatsAvailable() == (int) trip.getSeatsAvailable());
			assertTrue(trip.getGuides() instanceof ArrayList<?>);
		}
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void filterParameterShort()
	{
		TripDatabaseControllerMockupNotEmptyList tripDatabaseController = new TripDatabaseControllerMockupNotEmptyList();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList("tripName", "02/11/2017", "03/30/2017", "500", "490")));
		ArrayList<Trip> trips = this.getListOfTrips();

	}

	//Á þetta Test að vera með?
	//Erum við ekki að testa mockupið hérna?
	@Test 
	public void checkCategory()
	{
		TripDatabaseControllerMockupCategorySkiing tripDatabaseController = new TripDatabaseControllerMockupCategorySkiing();
		this.setTripDatabaseController(tripDatabaseController);
		this.search(new ArrayList<String>(Arrays.asList("tripName", "02/11/2017", "03/30/2017", "500", "490", "skiing")));
		ArrayList<Trip> trips = this.getListOfTrips();
		for(Trip trip : trips)
		{
			assertEquals("skiing", trip.getCategory());
		}
		
	}
			
}

