package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Trip;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.TripController;
import controller.TripSearchEngine;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTripsPanel extends JPanel {
	

	private FilterPanel filterPanel;
	private ListOfTripsPanel listOfTripsPanel;
	private TripController tripController;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public ViewTripsPanel(TripController tripctrl) {
		this.tripController = tripctrl;
		setLayout(null);
		
		listOfTripsPanel = new ListOfTripsPanel();
		
		filterPanel = new FilterPanel();
		filterPanel.setBounds(10, 11, 180, 363);
		add(filterPanel);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(200, 11, 765, 363);
		add(scrollPane);
		scrollPane.setViewportView(listOfTripsPanel); 
		
		btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Reset the ListOfTripspanel (else old trips will stay there)
				listOfTripsPanel = new ListOfTripsPanel();
				tripController.searchClicked();
				listOfTripsPanel.populateList(tripController.getListOfTrips());
				scrollPane.setViewportView(listOfTripsPanel);
			}
		});
		btnSearch.setBounds(61, 385, 89, 23);
		add(btnSearch);
	}


	
	public static void main(String[] args){
		
	}



	public FilterPanel getFilterPanel() {
		return filterPanel;
	}
}
