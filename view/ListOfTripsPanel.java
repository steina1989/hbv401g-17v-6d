package view;

import model.Trip;
import javax.swing.JPanel;

import controller.BookingController;
import controller.TripController;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;

/*
 * A panel used to display all the TripItems. It is nested inside ViewTripsPanel (easier to deal with Layout nuances)
 */

public class ListOfTripsPanel extends JPanel {
	
	private TripController tripController;
	private BookingController bookingController;
	

	/**
	 * Create the panel.
	 */
	public ListOfTripsPanel(TripController tripController, BookingController bookingController) {
		this.tripController = tripController;
		this.bookingController = bookingController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
	public void populateList(ArrayList<Trip> trips)
	{
		//System.out.println("Latest search:");
		for (Trip trip : trips)
		{
			TripItem tripItem = new TripItem(trip, this.tripController, this.bookingController);
			this.add(tripItem);
			//System.out.println(trip);
		}
		//System.out.println();
	}
	
	public void clearTrips() {
		this.removeAll();
		this.revalidate();
	}

}
