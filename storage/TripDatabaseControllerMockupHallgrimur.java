package storage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.Buyer;
import model.Guide;
import model.Location;
import model.Review;
import model.Trip;
import model.TripSearchCriteria;

public class TripDatabaseControllerMockupHallgrimur extends TripDatabaseController {
	@Override
	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) {

		// make some example dates
		Date exampleDate1 = new Date();
		Date exampleDate2 = new Date();
		Date exampleDate3 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		try {
			exampleDate1 = dateFormat.parse("2016-12-24");
		  exampleDate2 = dateFormat.parse("2016-02-16");
			exampleDate3 = dateFormat.parse("2017-07-07");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	  // create mockup trips
		Trip trip1 = new Trip("Golden Circle", 3, exampleDate1, 10, new Location(), 1500,
				"All the birds!", 25, "Safari", new ArrayList<Guide>());
		Trip trip2 = new Trip("South Coast", 1, exampleDate2, 10, new Location(), 1500,
				"https://www.youtube.com/watch?v=WNmCm4oyrkY", 25, "Safari", new ArrayList<Guide>());
		Trip trip3 = new Trip("Snæfellsnes", 1, exampleDate3, 10, new Location(), 1500,
				"YOLO", 30, "Skiing", new ArrayList<Guide>());
		
		ArrayList<Trip> tripResults = new ArrayList<>(Arrays.asList(trip1, trip2,  trip3));
		return tripResults;
	}
	
	@Override
	public ArrayList<Review> getTripReviews(int tripID) {
		// create mockup users
		Buyer user1 = new Buyer("Jónsi boy", 21, "KK", 8472095, "sexybeast123@gmail.com");
		Buyer user2 = new Buyer("Sara sæta", 23, "KVK", 6918342, "pm_me_ur_car@gmail.com");
		
		// create mockup reviews
		Review review1 = new Review(user1, "bitch plz", 2);
		Review review2 = new Review(user2, "lélegar rútur en góð þjónusta", 3);
		
		ArrayList<Review> reviewResults = new ArrayList<>(Arrays.asList(review1, review2));
		return reviewResults;
	}
}












































