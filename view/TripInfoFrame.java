package view;
import model.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.time.Duration;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JTable;

public class TripInfoFrame extends JFrame {
	
	/**
	 * @wbp.nonvisual location=263,-41
	 */
	private final JComboBox comboBox = new JComboBox();
	private JTextField txtNoGuests;
	private JTextField txtProduct;
	private JTextField txtTripName;
	private JTextField txtPrice;
	private Trip trip;
	private int noGuests;
	private String name, description, category;
	private int id, price, seatsAvailable, seatsUsed;
	private Calendar date;
	private ArrayList<Review> review; 
	private Location location;
	private ArrayList<Guide> guide;
	private Duration duration;
	private JTextField txtId;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TripInfoFrame() {
		// Dummy variables
		name = "Phallic";
		id = 023213;
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
		//Calendar date = new GregorianCalendar(2013,0,31,10,12);
		//review = new Review()
		//location = new Location() 
		price = 25;
		description = "Looking at Icelandic phallics";
		seatsAvailable = 29;
		seatsUsed = 10;
		category = "Sight seeing";
		// guides = new Guides();
		//duration = new Duration();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(100, 100, 696, 397);
		getContentPane().setLayout(null);
		
		JLabel lblNoOfGuests = new JLabel("No. of guests:");
		lblNoOfGuests.setBounds(85, 244, 109, 20);
		getContentPane().add(lblNoOfGuests);
		
		txtNoGuests = new JTextField();
		txtNoGuests.setText("No. guests");
		txtNoGuests.setBounds(209, 241, 146, 26);
		getContentPane().add(txtNoGuests);
		txtNoGuests.setColumns(10);
		
		txtProduct = new JTextField();
		txtProduct.setText("Product");
		txtProduct.setBounds(209, 283, 146, 26);
		getContentPane().add(txtProduct);
		txtProduct.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBounds(425, 240, 194, 69);
		getContentPane().add(btnAddToCart);
		
		txtTripName = new JTextField();
		txtTripName.setText(name);
		txtTripName.setBounds(209, 16, 146, 26);
		getContentPane().add(txtTripName);
		txtTripName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText(Integer.toString(price));
		txtPrice.setBounds(209, 61, 146, 26);
		getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(85, 289, 97, 20);
		getContentPane().add(lblTotalPrice);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(104, 19, 69, 20);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(104, 64, 69, 20);
		getContentPane().add(lblPrice);
		
		JLabel label = new JLabel("$");
		label.setBounds(197, 64, 16, 20);
		getContentPane().add(label);
		
		txtId = new JTextField();
		txtId.setText(Integer.toString(id));
		txtId.setBounds(493, 19, 146, 26);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(468, 22, 45, 20);
		getContentPane().add(lblId);
	}
}
