package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Trip;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ViewTripsPanel extends JPanel {
	

	private JPanel filterPanel;

	/**
	 * Create the panel.
	 */
	public ViewTripsPanel() {
		setLayout(null);
		filterPanel = new FilterPanel();
		filterPanel.setBounds(10, 11, 180, 363);
		add(filterPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(200, 11, 765, 363);
		add(scrollPane);
		
		ListOfTripsPanel listOfTripsPanel = new ListOfTripsPanel(new ArrayList<Trip>());
		scrollPane.setViewportView(listOfTripsPanel);

	}


	
	public static void main(String[] args){
		
	}
}
