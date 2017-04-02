package unitTests;

import java.util.ArrayList;

import model.*;

public class TripDatabaseControllerMockupEmpty extends TripDatabaseControllerMockup {

	
	
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray)
	{
		return new ArrayList<Trip>();
	}

}
