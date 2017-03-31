package storage;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

import model.*;

public class TripDatabaseControllerMockupCategorySkiing extends TripDatabaseControllerMockup {

	
	Buyer buyer = new Buyer("J�i",25,"Apache", 8489152, "joi@apache.com");
	Review review = new Review(buyer, "Flott fer�", 4);
	ArrayList<Review> reviewList = new ArrayList<Review>(Arrays.asList(review));
	Date date = new Date();
	Location location = new Location(new ArrayList<String>(), "Reykjav�k", "�safj�r�ur");
	Trip trip = new Trip("Bl�fj�ll", 1, date, reviewList, location, 1000,"L�sing:blaaa", 20,"skiing", new ArrayList<Guide>()); 
	Trip trip2 = new Trip("Hl��arfjall", 2, date, reviewList, location, 1000,"L�sing:bla", 20,"skiing", new ArrayList<Guide>()); 
	
	
	@Override
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray) {
		return new ArrayList<Trip>(Arrays.asList(trip,trip2));
	}

}
