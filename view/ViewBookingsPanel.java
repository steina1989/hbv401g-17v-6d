package view;

import java.awt.Color;

import javax.swing.*;
import controller.BookingController;
import model.Trip;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 
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
		setBackground(new Color(222, 184, 135));
		
		this.bookingController = bookingController;
		
		checkoutPanel = new CheckoutPanel(this.bookingController);
		checkoutPanel.setBounds(151, 0, 281, 294);
		checkoutPanel.setBackground(new Color(240, 240, 240));
		checkoutPanel.setVisible(true);
		setLayout(null);
		this.add(checkoutPanel);
		bookingInfoPanel = new BookingInfoPanel(this.bookingController);
		bookingInfoPanel.setBackground(new Color(240, 240, 240));
		bookingInfoPanel.setBounds(453, 0, 462, 122);
		add(bookingInfoPanel);
		
		JButton confirmBookingButton = new JButton("Confirm booking");
		confirmBookingButton.setBounds(730, 133, 185, 23);
		confirmBookingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!((JButton)e.getSource()).isEnabled()) return; // abort if button is not enabled
				bookingController.confirmBookingClicked();
			}
		});
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
