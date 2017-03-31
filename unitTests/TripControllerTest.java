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

	private MainFrame mainFrame;
	private TripController tripController;
	private TripDatabaseController tripDatabaseController;

	//public TripControllerTest() {
	//	super();
	//}
	
	//public TripControllerTest(MainFrame mf, TripDatabaseController dbctrl) {
	//	super(mf, dbctrl);
	//}
	
	@Before
	public void setUp() throws Exception {
	  mainFrame = new MainFrame();
		//tripController = this;
		//new TripController(mainFrame, tripDatabaseController);
		
		//this.setListOfTrips(tripDatabaseController.initializeListOfTripsVariable());
	}

	@After
	public void tearDown() throws Exception{
		mainFrame = null;
		tripDatabaseController = null;
		tripController = null;
		
	}

	@Test
	public void searchReturnsEmptyList() {
		tripDatabaseController = new TripDatabaseControllerMockupEmpty();
		this.setTripDatabaseController(tripDatabaseController);
		
		this.search(new ArrayList<String>(Arrays.asList("tripName", "02/11/2017", "03/30/2017", "500", "490", "skiing")));
		
		assertEquals(new ArrayList<String>(), tripController.getListOfTrips());
	}

	//@Test
	//public void searchReturnsCorrectTypes() {
	//	tripDatabaseController = new TripDatabaseControllerMockupHasTrips();
	//}

}

