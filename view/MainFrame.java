package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BookingController;
import controller.TripController;
import model.Review;
import model.Trip;

import model.Trip;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.SystemColor;

public class MainFrame extends JFrame {
	
	private JButton enterViewBookingsPanelButton;
	private JButton enterViewTripsPanelButton;
	
	private JLabel cartLabel;
	// This is the JPanel that contains everything in MainFrame
	private JPanel contentPane;
	private TripController tripController;
	private BookingController bookingController;
	private ViewTripsPanel viewTripsPanel;
	private ViewBookingsPanel viewBookingsPanel;
	private JButton cancelOldBookingButton;
	private CancelBookingFrame cancelBookingFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					//Centers the frame, no sure its works across all platforms
					frame.setLocationRelativeTo(null);
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
		
		this.tripController = new TripController(this);
		this.bookingController = new BookingController(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1138, 650);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("About this project");
		mnFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Creators:\n"
						+ "Hallgrimur David Egilsson\nJonas Gudmundsson\nOlafur Konrad  Albertsson\nSteina Dogg Vigfusdottir\n\n"
						+ "All icons designed by Madebyoliver from Flaticon.");
			}
		});
		menuBar.add(mnFile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		viewBookingsPanel = new ViewBookingsPanel(this.bookingController);
		System.out.println(this.getBackground());
		viewBookingsPanel.setBackground(this.getBackground());
		viewBookingsPanel.setBounds(0, 0, 1122, 537);
		viewBookingsPanel.setVisible(false);
		contentPane.add(viewBookingsPanel);
		
		//checkoutPanel = new CheckoutPanel(this.bookingController);
		//checkoutPanel.setBackground(Color.LIGHT_GRAY);
		//checkoutPanel.setBounds(10, 23, 463, 454);
		//checkoutPanel.setVisible(false);
		//contentPane.add(checkoutPanel);
		
		enterViewBookingsPanelButton = new JButton("Checkout");
		enterViewBookingsPanelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!((JButton)e.getSource()).isEnabled()) return; // abort if button is not enabled
				System.out.println("Opening checkout panel");
				bookingController.enterViewBookingsPanelClicked();
			}
		});
		enterViewBookingsPanelButton.setBounds(757, 564, 136, 23);
		contentPane.add(enterViewBookingsPanelButton);
		viewTripsPanel = new ViewTripsPanel(tripController, bookingController);
		viewTripsPanel.setBounds(10, 23, 1019, 454);
		contentPane.add(viewTripsPanel);
		
		cartLabel = new JLabel("Trips in cart: 0");
		cartLabel.setBounds(757, 548, 136, 14);
		contentPane.add(cartLabel);

		
		enterViewTripsPanelButton = new JButton("Browse trips");
		enterViewTripsPanelButton.setBounds(903, 564, 126, 23);
		contentPane.add(enterViewTripsPanelButton);
		enterViewTripsPanelButton.setEnabled(false);
		
		cancelOldBookingButton = new JButton("Cancel old booking");
		cancelOldBookingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Opening CancelBookingFrame");
				bookingController.cancelOldBookingButtonClicked();
			}
		});
		cancelOldBookingButton.setBounds(10, 564, 121, 23);
		contentPane.add(cancelOldBookingButton);
		enterViewTripsPanelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!((JButton)e.getSource()).isEnabled()) return; // abort if button is not enabled
				System.out.println("Opening View Trips panel");
				tripController.enterViewTripsPanelClicked();
			}
		});
		
		
		tripController.mainFrameInitialised();
	}
	
	public void openTripInfoFrame(Trip trip, ArrayList<Review> reviews) {
		TripInfoFrame frame = new TripInfoFrame(trip, reviews, this.bookingController);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
	public CancelBookingFrame getCancelBookingFrame() {
		return cancelBookingFrame;
	}

	public ViewTripsPanel getViewTripsPanel() {
		return this.viewTripsPanel;
	}
	
	public ViewBookingsPanel getViewBookingsPanel() {
		return this.viewBookingsPanel;
	}
	
	public void openCheckOutPanel(ArrayList<Trip> tripsFromCart){
		viewBookingsPanel.setTrips(tripsFromCart);
		viewTripsPanel.setVisible(false);
		viewBookingsPanel.setVisible(true);
		enterViewBookingsPanelButton.setEnabled(false);
		enterViewTripsPanelButton.setEnabled(true);
	}
	
	public void openViewTripsPanel(ArrayList<Trip> listOfTrips) {
		viewTripsPanel.setListOfTrips(listOfTrips);
		viewBookingsPanel.setVisible(false);
		viewTripsPanel.setVisible(true);
		enterViewTripsPanelButton.setEnabled(false);
		enterViewBookingsPanelButton.setEnabled(true);
	}
	
	public void setCartLabelText(int numTripsInCart) {
		this.cartLabel.setText("Trips in cart: " + numTripsInCart);
	}

	public void openCancelBookingFrame(){
		System.out.println("MainFrame.openCancelBookingFrame");
		cancelBookingFrame = new CancelBookingFrame(bookingController);
		cancelBookingFrame.setLocationRelativeTo(null);
		cancelBookingFrame.setVisible(true);
	}

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
