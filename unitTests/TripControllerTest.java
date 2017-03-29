package unitTests;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.TripController;
import storage.TripDatabaseControllerMockup;
import view.MainFrame;

/*
Prufum search a�fer�ina()
�a� skilar List of trips.
Test: Skilar alltaf lista, jafnvel t�mum.
Test: Fer�ir aldrei me� 0 e�a neikv�� s�ti
Test: Skilar r�ttum t�gum.
Test: M�tum db me� parameter t.d. Sk��fer�. Sko�um svo hvort == sk��afer�.
Test: 

Search kallar � getTripsByParameter sem skilar lista, tripctrller(enn inn� search fallinu)
 notar �ann lista til a� uppf�ra ListOfTripsPanel


*/

public class TripControllerTest {
	
	
	private JFrame mainFrame;
	private TripDatabaseControllerMockup tripDBcontroller;
	private TripController tripController;

	
	@Before
	public void setUp() throws Exception {
		mainFrame = new MainFrame();
		tripDBcontroller = new TripDatabaseControllerMockup();
		tripController = new TripController(mainFrame, tripDBcontroller);
	}

	@After
	public void tearDown() throws Exception {
		mainFrame = null;
		tripDBcontroller = null;
	}

	@Test
	public void test() {
		
	}

}

