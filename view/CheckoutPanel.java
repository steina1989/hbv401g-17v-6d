package view;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import controller.BookingController;
import model.Trip;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class CheckoutPanel extends JPanel {
	
	private BookingController bookingController;
	private JButton cancelTripButton;
	private JPanel bookingInfoPanel;
	
	private ArrayList<Trip> tripsInCart;
	private DefaultListModel<String> listModel;
	private JList tripsInCartJList;

	/**
	 * Create the panel.
	 */
	public CheckoutPanel(BookingController bookingController) {
		setBackground(SystemColor.inactiveCaption);
		this.bookingController = bookingController;
		
		this.listModel = new DefaultListModel<String>();
		
		setLayout(null);
		
		bookingInfoPanel = new JPanel();
		bookingInfoPanel.setBackground(Color.GRAY);
		bookingInfoPanel.setBounds(21, 26, 204, 213);
		add(bookingInfoPanel);
		bookingInfoPanel.setLayout(null);
		
		tripsInCartJList = new JList(listModel);
		tripsInCartJList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tripsInCartJList.setBounds(0, 0, 204, 213);
		tripsInCartJList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				bookingController.tripsInCartJListClicked();
			}
		});
		bookingInfoPanel.add(tripsInCartJList);
		
		cancelTripButton = new JButton("Cancel trip");
		cancelTripButton.setBounds(31, 250, 174, 23);
		cancelTripButton.setEnabled(false);
		cancelTripButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!((JButton)e.getSource()).isEnabled()) return; // abort if button is not enabled
				System.out.println("Opening View Trips panel");
				bookingController.cancelTripButtonClicked();
			}
		});
		add(cancelTripButton);
		
	}
	
	public void populateJList(ArrayList<Trip> trips){
		listModel.clear();
		for (Trip trip : trips){
			listModel.addElement(trip.getName() + ", ID: " + trip.getId());
		}
		//bookingInfoPanel.add(jListorder);
	}
	
	public JList getTripsInCartJList() {
		return this.tripsInCartJList;
	}
	
	public JButton getCancelTripButton() {
		return this.cancelTripButton;
	}
}
