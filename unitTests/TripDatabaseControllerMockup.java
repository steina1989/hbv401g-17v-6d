package unitTests;

import java.util.ArrayList;
import model.*;
import storage.TripDatabaseController;

/*
 * Abstract "base" class to build specific cases of TripDataBaseControllerMockups.
 */

abstract public class TripDatabaseControllerMockup extends TripDatabaseController {
	
	abstract public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray);


}
