package unitTests;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

import model.*;

/*
 * This class returns a non empty list of Trips. It is used now primarily for JUnit testing with regards 
 * to sorting by date.
 */

public class TripDatabaseControllerMockupNotEmptyList extends TripDatabaseControllerMockup {

	Buyer buyer = new Buyer("J�i",25,"Apache", 8489152, "joi@apache.com");
	Review review = new Review(buyer, "Flott fer�", 4);
	ArrayList<Review> reviewList = new ArrayList<Review>(Arrays.asList(review));
	Date datefirst = new Date(1);
	Date datesecond = new Date(2);
	Location location = new Location(new ArrayList<String>(), "Reykjav�k", "�safj�r�ur");
	Trip firsttrip = new Trip("Esjufer�", 1, datefirst, reviewList, location, 1000,"L�sing:blaaa", 20,"action", new ArrayList<Guide>()); 
	Trip secondtrip = new Trip("Sj�fer�", 2, datesecond, reviewList, location, 1000,"L�sing:blaaa", 20,"action", new ArrayList<Guide>()); 
	
	
	@Override
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray) {
		return new ArrayList<Trip>(Arrays.asList(secondtrip,firsttrip));
	}

}
