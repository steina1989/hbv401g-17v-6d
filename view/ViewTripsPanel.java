package view;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import controller.TripController;
import model.Trip;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

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
	private JRadioButton rdbtnDate;
	private JRadioButton rdbtnAscending;
	private JRadioButton rdbtnDescending;
	private JLabel lblSortBy;

	/**
	 * Create the panel.
	 */
	public ViewTripsPanel(TripController tripctrl) {
		this.tripController = tripctrl;
		setLayout(null);
		
		listOfTripsPanel = new ListOfTripsPanel(this.tripController);
		
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
				tripController.searchClicked();
			}
		});
		btnSearch.setBounds(61, 414, 89, 23);
		add(btnSearch);
		
		rdbtnDate = new JRadioButton("Date");
		rdbtnDate.setSelected(true);
		rdbtnDate.setBounds(308, 10, 49, 23);
		add(rdbtnDate);
		rdbtnDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tripController.sortClicked();
			}
		});
		
		rdbtnPrice = new JRadioButton("Price");
		rdbtnPrice.setBounds(359, 10, 49, 23);
		add(rdbtnPrice);
		rdbtnPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tripController.sortClicked();
			}
		});
		
		ButtonGroup sortByGroup = new ButtonGroup();
		sortByGroup.add(rdbtnDate);
		sortByGroup.add(rdbtnPrice);
		
		lblSortBy = new JLabel("Sort by:");
		lblSortBy.setBounds(266, 15, 46, 14);
		add(lblSortBy);
		
		JLabel lblInOrder = new JLabel("In order:");
		lblInOrder.setBounds(419, 14, 46, 14);
		add(lblInOrder);
		
		rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setBounds(468, 10, 75, 23);
		rdbtnAscending.setSelected(true);
		add(rdbtnAscending);
		rdbtnAscending.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tripController.sortClicked();
			}
		});
		
		rdbtnDescending = new JRadioButton("Descending");
		rdbtnDescending.setBounds(545, 10, 109, 23);
		add(rdbtnDescending);
		rdbtnDescending.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tripController.sortClicked();
			}
		});
		
		ButtonGroup sortByAscGroup = new ButtonGroup();
		sortByAscGroup.add(rdbtnAscending );
		sortByAscGroup.add(rdbtnDescending);
		//sortByAscGroup.addMouseListener(new MouseAdapter() {
		//	@Override
		//	public void mousePressed(MouseEvent e) {
		//		tripController.searchClicked();
		//	}
		//});
		
	}
	
	public void filterChanged(){
		
	}

	public void renderTrips(ArrayList<Trip> tripsToRender)
	{
		//Reset the ListOfTripspanel (else old trips will stay there)
		listOfTripsPanel.clearTrips();
		listOfTripsPanel.populateList(tripController.getListOfTrips());
		//scrollPane.setViewportView(listOfTripsPanel);
	}

	
	public static void main(String[] args){
		
	}



	public FilterPanel getFilterPanel() {
		return filterPanel;
	}
	
	public String getAttributeToSortBy() {
		if (rdbtnPrice.isSelected()) return "Price";
		else if (rdbtnDate.isSelected()) return "Date";
		return "";
	}
	
	public Boolean getSortingDirection() {
		if (rdbtnAscending.isSelected()) return true;
		else return false;
	}
	
	public ArrayList<JRadioButton> getSortingAttributeRadioButtons() {
		return new ArrayList<>(Arrays.asList(rdbtnPrice, rdbtnDate));
	}
	
	public ArrayList<JRadioButton> getSortingDirectionRadioButtons() {
		return new ArrayList<>(Arrays.asList(rdbtnAscending, rdbtnDescending));
	}
}
