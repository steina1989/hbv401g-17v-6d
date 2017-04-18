package view;

import java.awt.Color;

import javax.swing.*;
import controller.BookingController;
import model.Trip;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import view.BookingInfoPanel;
import java.util.ArrayList;

public class ViewBookingsPanel extends JPanel {
	private final BookingController bookingController;
	private CheckoutPanel checkoutPanel;
	private BookingInfoPanel bookingInfoPanel;
	
	/**
	 * Create the panel.
	 */
	public ViewBookingsPanel(final BookingController bookingController) {
		
		this.bookingController = bookingController;
		
		checkoutPanel = new CheckoutPanel(this.bookingController);
		checkoutPanel.setBounds(0, 0, 446, 294);
		checkoutPanel.setBackground(Color.LIGHT_GRAY);
		checkoutPanel.setVisible(true);
		setLayout(null);
		this.add(checkoutPanel);
		bookingInfoPanel = new BookingInfoPanel(this.bookingController);
		bookingInfoPanel.setBackground(new Color(224, 255, 255));
		bookingInfoPanel.setBounds(453, 0, 462, 294);
		add(bookingInfoPanel);
		
		JButton confirmBookingButton = new JButton("Confirm booking");
		confirmBookingButton.setBounds(730, 305, 185, 23);
		add(confirmBookingButton);
	}
	
	
	public void setTrips(ArrayList<Trip> trips){
		populateJList(trips);
		calculateTotalPrice();
	}
	
	private void populateJList(ArrayList<Trip> trips){
		this.checkoutPanel.populateJList(trips);
	}
	
	private void calculateTotalPrice(){
		
	}
	
	
	public BookingInfoPanel getBookingInfoPanel() {
		return bookingInfoPanel;
	}


	public CheckoutPanel getCheckoutPanel() {
		return this.checkoutPanel;
	}
}
