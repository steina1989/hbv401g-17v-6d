package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ListOfTripsPanel extends JPanel {
	
	private JList tripList;
	private DefaultListModel<String> tripNames;

	/**
	 * Create the panel.
	 */
	public ListOfTripsPanel() {
		setLayout(null);
		
		tripNames = new DefaultListModel<String>();
		this.addExampleTripNames();
		
		JList list = new JList();
		list.setBounds(0, 0, 209, 300);
		list.setModel(tripNames);
		add(list);
	}
	
	private void addExampleTripNames() {
		this.tripNames.addElement("TripName1");
		this.tripNames.addElement("TripName2");
		this.tripNames.addElement("TripName3");
		this.tripNames.addElement("TripName4");
		this.tripNames.addElement("TripName5");
	}
}
