package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TripControllerTest {

	
	@Before
	public void setUp() {

	}
	
	@After
	public void tearDown() {
		
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

/*
Prufum search aðferðina()
Það skilar List of trips.
Test: Skilar alltaf lista, jafnvel tómum.
Test: Ferðir aldrei með 0 eða neikvæð sæti
Test: Skilar réttum tögum.
Test: Mötum db með parameter t.d. Skíðferð. Skoðum svo hvort == skíðaferð.
Test: 

Search kallar á getTripsByParameter sem skilar lista, tripctrller(enn inní search fallinu)
 notar þann lista til að uppfæra ListOfTripsPanel


*/