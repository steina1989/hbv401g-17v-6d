package unitTests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.TripController;
import storage.TripDatabaseController;
import storage.TripDatabaseControllerMockup;
import storage.TripDatabaseControllerMockupEmpty;
import view.MainFrame;

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
		
		assertEquals(new ArrayList<String>(),this.getListOfTrips());
	}


	
	
}

