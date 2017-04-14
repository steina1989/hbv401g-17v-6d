package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TripController;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {
	
	private JButton enterBookingPanelButton;
	// This is the JPanel that contains everything in MainFrame
	private JPanel contentPane;
	
	private TripController tripcontroller;
	private ViewTripsPanel viewTripsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1138, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel viewBookingsPanel = new JPanel(); // TODO: when ViewBookingsPanel has been added to view folder change line to viewBookingsPanel = new ViewBookingsPanel();
		viewBookingsPanel.setBackground(Color.BLUE);
		viewBookingsPanel.setBounds(623, 537, 153, 50);
		contentPane.add(viewBookingsPanel);
		
		JPanel checkoutPanel = new JPanel(); // TODO: when CheckoutPanel has been added to view folder change line to checkoutPanel = new CheckoutPanel;
		checkoutPanel.setBackground(Color.MAGENTA);
		checkoutPanel.setBounds(462, 537, 153, 51);
		contentPane.add(checkoutPanel);
		
		enterBookingPanelButton = new JButton("Enter booking");
		enterBookingPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Opna checkout panel
			}
		});
		enterBookingPanelButton.setBounds(786, 564, 136, 23);
		contentPane.add(enterBookingPanelButton);
		
		
		tripcontroller = new TripController(this);
		
		viewTripsPanel = new ViewTripsPanel(tripcontroller);
		viewTripsPanel.setBounds(38, 23, 991, 417);
		contentPane.add(viewTripsPanel);
		
		
		
	}

	public ViewTripsPanel getViewTripsPanel() {
		return viewTripsPanel;
	}
	
	


}
