package view;

import model.Trip;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

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
