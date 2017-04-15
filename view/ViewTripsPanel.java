package view;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import controller.TripController;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;


/*
 * This panel encapsulates FilterPanel and ListOfTripsPanel
 * To do: 
 * 1. Stop the automatic scrolling down when ListOfTrips is populated
 * 2. Add buttons to enable user to filter the list.
 */

public class ViewTripsPanel extends JPanel {

	private FilterPanel filterPanel;
	private ListOfTripsPanel listOfTripsPanel;
	private TripController tripController;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnPrice;
	private JLabel lblSortBy;

	/**
	 * Create the panel.
	 */
	public ViewTripsPanel(TripController tripctrl) {
		this.tripController = tripctrl;
		setLayout(null);
		
		listOfTripsPanel = new ListOfTripsPanel();
		
		filterPanel = new FilterPanel();
		filterPanel.setBounds(10, 40, 246, 363);
		add(filterPanel);
				
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(266, 40, 699, 363);
		add(scrollPane);
		scrollPane.setViewportView(listOfTripsPanel); 
		btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				renderTrips();
			}
		});
		btnSearch.setBounds(61, 414, 89, 23);
		add(btnSearch);
		
		JRadioButton rdbtnDate = new JRadioButton("Date");
		rdbtnDate.setSelected(true);
		rdbtnDate.setBounds(308, 10, 49, 23);
		add(rdbtnDate);
		
		rdbtnPrice = new JRadioButton("Price");
		rdbtnPrice.setBounds(359, 10, 49, 23);
		add(rdbtnPrice);
		
		ButtonGroup sortByGroup = new ButtonGroup();
		sortByGroup.add(rdbtnDate);
		sortByGroup.add(rdbtnPrice);
		
		lblSortBy = new JLabel("Sort by:");
		lblSortBy.setBounds(266, 15, 46, 14);
		add(lblSortBy);
		
		JLabel lblInOrder = new JLabel("In order:");
		lblInOrder.setBounds(419, 14, 46, 14);
		add(lblInOrder);
		
		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setBounds(468, 10, 75, 23);
		add(rdbtnAscending);
		
		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setBounds(545, 10, 109, 23);
		add(rdbtnDescending);
		
		ButtonGroup sortByAscGroup = new ButtonGroup();
		sortByAscGroup.add(rdbtnAscending );
		sortByAscGroup.add(rdbtnDescending);
		
	}
	
	public void filterChanged(){
		
	}

	public void renderTrips()
	{
		//Reset the ListOfTripspanel (else old trips will stay there)
		listOfTripsPanel = new ListOfTripsPanel();
		tripController.searchClicked();
		listOfTripsPanel.populateList(tripController.getListOfTrips());
		scrollPane.setViewportView(listOfTripsPanel);
	}

	
	public static void main(String[] args){
		
	}



	public FilterPanel getFilterPanel() {
		return filterPanel;
	}
}
