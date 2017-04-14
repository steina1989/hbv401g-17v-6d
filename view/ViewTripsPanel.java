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

	/**
	 * Create the panel.
	 */
	public ViewTripsPanel(TripController tripctrl) {
		this.tripController = tripctrl;
		setLayout(null);
		
		listOfTripsPanel = new ListOfTripsPanel();
		
		filterPanel = new FilterPanel();
		filterPanel.setBounds(10, 11, 246, 363);
		add(filterPanel);
				
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(266, 11, 699, 363);
		add(scrollPane);
		scrollPane.setViewportView(listOfTripsPanel); 
		
		btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				renderTrips();
			}
		});
		btnSearch.setBounds(61, 384, 89, 23);
		add(btnSearch);
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
