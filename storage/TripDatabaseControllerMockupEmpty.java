package storage;

import java.util.ArrayList;

import model.*;

public class TripDatabaseControllerMockupEmpty extends TripDatabaseController {

	
	//Gera fleiri fer�ir og b�ta �eim vi� arraylist<Trip>
	
	
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray)
	{
		return new ArrayList<Trip>();
	}

}
