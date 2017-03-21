package model;
import java.util.*;

public class Location {
	
	// Location has three fields
	private ArrayList<String> destinations;
	private String placeOfDeparture, placeOfReturn;
	

	// The Location class has one constructor
	public Location(ArrayList<String> destination, String placeOfDepartue, String placeOfReturn){

	}

	// The Location class has three getters and three setters
	public ArrayList<String> getDestination() {
		return destinations;
	}


	public void setDestination(ArrayList<String> destination) {
		this.destinations = destination;
	}


	public String getPlaceOfDeparture() {
		return placeOfDeparture;
	}


	public void setPlaceOfDeparture(String placeOfDeparture) {
		this.placeOfDeparture = placeOfDeparture;
	}


	public String getPlaceOfReturn() {
		return placeOfReturn;
	}


	public void setPlaceOfReturn(String placeOfReturn) {
		this.placeOfReturn = placeOfReturn;
	}
	
	
	
	

}
