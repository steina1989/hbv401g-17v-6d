package storage;

import java.util.ArrayList;

import model.*;

public class TripDatabaseControllerMockup {
	
	Buyer buyer = new Buyer("J�i",25,"Apache", 8489152, "joi@apache.com");
	Review review = new Review(buyer, "Flott fer�", 4);
	Trip trip = new Trip(); //kl�ra a� fylla inn h�r
	
	//Gera fleiri fer�ir og b�ta �eim vi� arraylist<Trip>
	
	
	public ArrayList<Trip> getTripsByParameter(ArrayList<String> filterArray)
	{
		return null;
	}

}
