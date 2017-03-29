package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	
	// TODO: uncomment when classes have been added to view folder
	//private BookingController bookingController;
	private JPanel listOfTripsPanel;
	//private JPanel viewBookingsPanel;
	//private JFrame tripInfoFrame;
	//private JPanel checkoutPanel;
	private JButton enterBookingPanelButton;

	// This is the JPanel that contains everything in MainFrame
	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listOfTripsPanel = new ListOfTripsPanel();
		listOfTripsPanel.setBackground(Color.DARK_GRAY);
		listOfTripsPanel.setBounds(10, 11, 136, 240);
		contentPane.add(listOfTripsPanel);
		
		JPanel viewBookingsPanel = new JPanel(); // TODO: when ViewBookingsPanel has been added to view folder change line to viewBookingsPanel = new ViewBookingsPanel();
		viewBookingsPanel.setBackground(Color.BLUE);
		viewBookingsPanel.setBounds(169, 146, 153, 50);
		contentPane.add(viewBookingsPanel);
		
		JPanel checkoutPanel = new JPanel(); // TODO: when CheckoutPanel has been added to view folder change line to checkoutPanel = new CheckoutPanel;
		checkoutPanel.setBackground(Color.MAGENTA);
		checkoutPanel.setBounds(169, 84, 153, 51);
		contentPane.add(checkoutPanel);
		
		enterBookingPanelButton = new JButton("Enter booking");
		enterBookingPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		enterBookingPanelButton.setBounds(288, 228, 136, 23);
		contentPane.add(enterBookingPanelButton);
	}

	public JPanel getListOfTripsPanel() {
		return listOfTripsPanel;
	}
	
	
	
}
