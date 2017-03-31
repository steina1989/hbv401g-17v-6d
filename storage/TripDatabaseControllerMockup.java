package storage;

import java.util.ArrayList;
import model.*;

abstract public class TripDatabaseControllerMockup extends TripDatabaseController {
	
	abstract public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray);


}
