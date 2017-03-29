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

public class TripControllerTest {
	
	
	private JFrame mainFrame;
	private TripController tripController;

	
	@Before
	public void setUp() throws Exception {
		mainFrame = new MainFrame();
		tripDBcontroller = new TripDatabaseControllerMockup();
		tripController = new TripController(mainFrame);
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

