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
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		viewTripsPanel.setBounds(10, 23, 1019, 454);
		contentPane.add(viewTripsPanel);
		
		//This needs to be here (as opposed to in the constructor of the viewTripsPanel itself), 
		//because renderTrips can only run after Constructor of viewTripsPanel has been completed.
		//To show trips based on the default criteria:
		tripcontroller.searchClicked();
	}

	public ViewTripsPanel getViewTripsPanel() {
		return viewTripsPanel;
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
