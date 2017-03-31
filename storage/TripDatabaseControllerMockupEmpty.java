package storage;

import java.util.ArrayList;

import model.*;

public class TripDatabaseControllerMockupEmpty extends TripDatabaseController {

	
	//Gera fleiri ferðir og bæta þeim við arraylist<Trip>
	
	
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray)
	{
		return new ArrayList<Trip>();
	}

}
