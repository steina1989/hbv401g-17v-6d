package storage;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

import model.*;

public class TripDatabaseControllerMockupCategorySkiing extends TripDatabaseControllerMockup {

	
	Buyer buyer = new Buyer("Jói",25,"Apache", 8489152, "joi@apache.com");
	Review review = new Review(buyer, "Flott ferð", 4);
	ArrayList<Review> reviewList = new ArrayList<Review>(Arrays.asList(review));
	Date date = new Date();
	Location location = new Location(new ArrayList<String>(), "Reykjavík", "Ísafjörður");
	Trip trip = new Trip("Bláfjöll", 1, date, reviewList, location, 1000,"Lýsing:blaaa", 20,"skiing", new ArrayList<Guide>()); 
	Trip trip2 = new Trip("Hlíðarfjall", 2, date, reviewList, location, 1000,"Lýsing:bla", 20,"skiing", new ArrayList<Guide>()); 
	
	
	@Override
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray) {
		return new ArrayList<Trip>(Arrays.asList(trip,trip2));
	}

}
