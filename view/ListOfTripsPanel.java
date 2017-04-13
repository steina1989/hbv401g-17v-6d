package view;

import model.Trip;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class ListOfTripsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListOfTripsPanel(ArrayList<Trip> trips) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		TripItem tripItem = new TripItem((Trip) null);
		add(tripItem);
		
		TripItem tripItem_1 = new TripItem((Trip) null);
		add(tripItem_1);
		
		TripItem tripItem_2 = new TripItem((Trip) null);
		add(tripItem_2);
		
		TripItem tripItem_3 = new TripItem((Trip) null);
		add(tripItem_3);

	//	for (Trip trip : trips){
	//		this.add(new TripItem(trip));
	//	}

	}

}
