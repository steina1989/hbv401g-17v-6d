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
Prufum search a�fer�ina()
�a� skilar List of trips.
Test: Skilar alltaf lista, jafnvel t�mum.
Test: Fer�ir aldrei me� 0 e�a neikv�� s�ti
Test: Skilar r�ttum t�gum.
Test: M�tum db me� parameter t.d. Sk��fer�. Sko�um svo hvort == sk��afer�.

Erum mest a� athuga me� validation � input drasli ��ur en vi� k�llum � getTripsby.....
Testum filterfylki�.

Search kallar � getTripsByParameter sem skilar lista, tripctrller(enn inn� search fallinu)
 notar �ann lista til a� uppf�ra ListOfTripsPanel


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

