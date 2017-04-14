package view;

import model.Trip;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.BoxLayout;

/*
 * A panel used to display all the TripItems. It is nested inside ViewTripsPanel (easier to deal with Layout nuances)
 */

public class ListOfTripsPanel extends JPanel {
	
	

	/**
	 * Create the panel.
	 */
	public ListOfTripsPanel() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void populateList(ArrayList<Trip> trips)
	{
	
		for (Trip trip : trips)
		{
			this.add(new TripItem(trip));
		}

	}

}
