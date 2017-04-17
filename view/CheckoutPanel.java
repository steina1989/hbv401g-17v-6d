package view;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import controller.BookingController;
import model.Trip;
import javax.swing.JList;

public class CheckoutPanel extends JPanel {
	
	private BookingController bookingController;
	private JPanel bookingInfoPanel;
	private JButton addBookingButton;
	private JButton cancelBookingButton;
	private ArrayList<Trip> tripsInCart;
	private DefaultListModel<String> listModel;
	private JList tripsInCartJList;

	/**
	 * Create the panel.
	 */
	public CheckoutPanel(BookingController bookingController) {
		this.bookingController = bookingController;
		
		this.listModel = new DefaultListModel<String>();
		
		setLayout(null);
		
		bookingInfoPanel = new JPanel();
		bookingInfoPanel.setBackground(Color.GRAY);
		bookingInfoPanel.setBounds(21, 26, 204, 249);
		add(bookingInfoPanel);
		bookingInfoPanel.setLayout(null);
		
		tripsInCartJList = new JList(listModel);
		tripsInCartJList.setBounds(0, 0, 204, 249);
		bookingInfoPanel.add(tripsInCartJList);
		
		addBookingButton = new JButton("Confirm booking");
		addBookingButton.setBounds(253, 226, 174, 23);
		add(addBookingButton);
		
		cancelBookingButton = new JButton("Cancel booking");
		cancelBookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cancelBookingButton.setBounds(253, 252, 174, 23);
		add(cancelBookingButton);
		
	}
	
	
	public void setTrips(ArrayList<Trip> trips){
		populateJList(trips);
		calculateTotalPrice();
	}
	
	private void populateJList(ArrayList<Trip> trips){
		for (Trip trip : trips){
			listModel.addElement(trip.getName() + ", ID: " + trip.getId());
		}
		//bookingInfoPanel.add(jListorder);
	}
	
	private void calculateTotalPrice(){
		
	}
}
