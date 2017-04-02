package unitTests;

import java.util.ArrayList;

import model.*;

public class TripDatabaseControllerMockupEmpty extends TripDatabaseControllerMockup {

	/*
	 * This subclass returns an empty list of trips. It is used to cover extreme cases later in development.
	 */
	
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray)
	{
		return new ArrayList<Trip>();
	}

}
