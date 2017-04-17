package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BookingController;
import controller.TripController;
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

public class MainFrame extends JFrame {
	
	private JButton enterCheckoutPanelButton;
	private JButton enterViewTripsPanelButton;
	
	private JLabel cartLabel;
	// This is the JPanel that contains everything in MainFrame
	private JPanel contentPane;
	private TripController tripController;
	private BookingController bookingController;
	private ViewTripsPanel viewTripsPanel;
	private CheckoutPanel checkoutPanel;

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
		
		JPanel viewBookingsPanel = new JPanel(); // TODO: when ViewBookingsPanel has been added to view folder change line to viewBookingsPanel = new ViewBookingsPanel();
		viewBookingsPanel.setBackground(Color.BLUE);
		viewBookingsPanel.setBounds(448, 537, 153, 50);
		contentPane.add(viewBookingsPanel);
		
		checkoutPanel = new CheckoutPanel(this.bookingController);
		checkoutPanel.setBackground(Color.MAGENTA);
		checkoutPanel.setBounds(10, 23, 1019, 454);
		checkoutPanel.setVisible(false);
		contentPane.add(checkoutPanel);
		
		enterCheckoutPanelButton = new JButton("Checkout");
		enterCheckoutPanelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Opening checkout panel");
				viewTripsPanel.setVisible(false);
				checkoutPanel.setVisible(true);
				
				enterCheckoutPanelButton.setEnabled(false);
				enterViewTripsPanelButton.setEnabled(true);
			}
		});
		enterCheckoutPanelButton.setBounds(757, 564, 136, 23);
		contentPane.add(enterCheckoutPanelButton);
		viewTripsPanel = new ViewTripsPanel(tripController, bookingController);
		viewTripsPanel.setBounds(10, 23, 1019, 454);
		contentPane.add(viewTripsPanel);
		
		cartLabel = new JLabel("Trips in cart: 0");
		cartLabel.setBounds(747, 549, 136, 14);
		contentPane.add(cartLabel);

		
		enterViewTripsPanelButton = new JButton("Browse trips");
		enterViewTripsPanelButton.setBounds(903, 564, 126, 23);
		contentPane.add(enterViewTripsPanelButton);
		enterViewTripsPanelButton.setEnabled(false);
		enterViewTripsPanelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Opening View Trips panel");

			}
		});
		
		//This needs to be here (as opposed to in the constructor of the viewTripsPanel itself), 
		//because renderTrips can only run after Constructor of viewTripsPanel has been completed.
		//To show trips based on the default criteria:
		tripController.searchClicked();
	}

	public ViewTripsPanel getViewTripsPanel() {
		return viewTripsPanel;
	}
	

	public void openCheckOutPanel(ArrayList<Trip> tripsFromCart){
		
		checkoutPanel.setTrips(tripsFromCart);
		checkoutPanel.setVisible(true);
		viewTripsPanel.setVisible(false);
		enterViewTripsPanelButton.setEnabled(false);
		enterCheckoutPanelButton.setEnabled(true);

	}
	
	
	public void setCartLabelText(int numTripsInCart) {
		this.cartLabel.setText("Trips in cart: " + numTripsInCart);
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
