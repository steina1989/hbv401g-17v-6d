package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.BookingController;

public class CheckoutPanel extends JPanel {
	
	private BookingController bookingController;
	private JPanel bookingInfoPanel;
	private JButton addBookingButton;
	private JButton cancelBookingButton;

	/**
	 * Create the panel.
	 */
	public CheckoutPanel(BookingController bookingController) {
		this.bookingController = bookingController;
		
		setLayout(null);
		
		bookingInfoPanel = new JPanel();
		bookingInfoPanel.setBackground(Color.GRAY);
		bookingInfoPanel.setBounds(21, 26, 204, 249);
		add(bookingInfoPanel);
		
		addBookingButton = new JButton("Add booking");
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
}
