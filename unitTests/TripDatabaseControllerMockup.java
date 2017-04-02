package unitTests;

import java.util.ArrayList;
import model.*;
import storage.TripDatabaseController;

abstract public class TripDatabaseControllerMockup extends TripDatabaseController {
	
	abstract public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray);


}
