package storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.*;

public class TripDatabaseControllerMockup {
	
	Buyer buyer = new Buyer("Jói",25,"Apache", 8489152, "joi@apache.com");
	Review review = new Review(buyer, "Flott ferð", 4);
	ArrayList<Review> reviewList = new ArrayList<Review>(Arrays.asList(review));
	Date date = new Date();
	Location location = new Location(new ArrayList<String>(), "Reykjavík", "Ísafjörður");
	Trip trip = new Trip("Esjuferð", 1, date, reviewList, location, 1000,"Lýsing:blaaa", 20,"skiing", new ArrayList<Guide>()); 

	
	
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray)
	{
		return new ArrayList<Trip>(Arrays.asList(trip));
	}

}
