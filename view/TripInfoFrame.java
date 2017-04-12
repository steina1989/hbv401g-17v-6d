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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.time.Duration;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TripInfoFrame extends JFrame {
	
	/**
	 * @wbp.nonvisual location=263,-41
	 */
	private final JComboBox comboBox = new JComboBox();
	private JTextField txtNoGuests;
	private JTextField txtProduct;
	private JTextField txtTripName;
	private JTextField txtPrice;
	private JTextField txtId;
	private JTextField txtPlaceOfDeparture;
	private JTextField txtDate;
	private JTextField txtCategory;
	private JTextField txtSeatsAvailable;
	private JTextField txtSeatsUsed;
	private JTextField txtGuides;
	private JTextField txtDuration;
	private Trip trip;
	private int noGuests, totalPrice;
	private JTextField txtPlaceOfArrival;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TripInfoFrame() {
		// Dummy variables
		int price = 25;
		String description = "Looking at Icelandic phallics";
		int seatsAvailable = 29;
		int seatsLeft = 10;
		String category = "Sight seeing";
		String name = "Phallic";
		int id = 023213;
		String placeOfArrival = "Selfoss";
		String placeOfDeparture = "Reykjavík";
		String duration = minuteToTime(300);
		// Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        Calendar calendar = new GregorianCalendar(2013,1,28);
        String date = sdf.format(calendar.getTime());
        // Guides
        ArrayList<String> x = new ArrayList<>(Arrays.asList("Þórður", "Sigga"));
        String guides = seperateGuides(x);
		

		
		
		// The frame itself and buttons
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(100, 100, 697, 652);
		getContentPane().setLayout(null);
		
		JLabel lblNoOfGuests = new JLabel("No. of guests:");
		lblNoOfGuests.setBounds(64, 380, 109, 20);
		getContentPane().add(lblNoOfGuests);
		
		txtNoGuests = new JTextField();
		txtNoGuests.setText("0");
		txtNoGuests.setBounds(209, 377, 146, 26);
		getContentPane().add(txtNoGuests);
		txtNoGuests.setColumns(10);
		
		txtProduct = new JTextField();
		txtProduct.setEditable(false);
		txtProduct.setText("0");
		txtProduct.setBounds(209, 413, 146, 26);
		getContentPane().add(txtProduct);
		txtProduct.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBounds(428, 410, 211, 29);
		getContentPane().add(btnAddToCart);
		
		txtTripName = new JTextField();
		txtTripName.setEditable(false);
		txtTripName.setText(name);
		txtTripName.setBounds(209, 16, 146, 26);
		getContentPane().add(txtTripName);
		txtTripName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setText(Integer.toString(price));
		txtPrice.setBounds(209, 61, 146, 26);
		getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(64, 416, 97, 20);
		getContentPane().add(lblTotalPrice);
		
		JLabel lblName = new JLabel("Trip name:");
		lblName.setBounds(64, 19, 109, 20);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(64, 64, 69, 20);
		getContentPane().add(lblPrice);
		
		JLabel label = new JLabel("$");
		label.setBounds(197, 64, 16, 20);
		getContentPane().add(label);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setText(Integer.toString(id));
		txtId.setBounds(493, 19, 146, 26);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Trip id:");
		lblId.setBounds(414, 19, 81, 20);
		getContentPane().add(lblId);
		
		JLabel lblLocation = new JLabel("Place of departure:");
		lblLocation.setBounds(64, 336, 149, 20);
		getContentPane().add(lblLocation);
		
		txtPlaceOfDeparture = new JTextField();
		txtPlaceOfDeparture.setEditable(false);
		txtPlaceOfDeparture.setText(placeOfDeparture);
		txtPlaceOfDeparture.setBounds(209, 333, 146, 26);
		getContentPane().add(txtPlaceOfDeparture);
		txtPlaceOfDeparture.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(414, 64, 69, 20);
		getContentPane().add(lblNewLabel);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setText(date);
		txtDate.setBounds(493, 61, 146, 26);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(64, 110, 69, 20);
		getContentPane().add(lblCategory);
		
		txtCategory = new JTextField();
		txtCategory.setEditable(false);
		txtCategory.setText(category);
		txtCategory.setBounds(209, 107, 146, 26);
		getContentPane().add(txtCategory);
		txtCategory.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(64, 146, 97, 20);
		getContentPane().add(lblDescription);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setText(description);
		txtDescription.setEditable(false);
		txtDescription.setBounds(209, 149, 430, 76);
		getContentPane().add(txtDescription);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		
		JLabel lblSeatsAvailable = new JLabel("Seats available:");
		lblSeatsAvailable.setBounds(64, 264, 109, 20);
		getContentPane().add(lblSeatsAvailable);
		
		JLabel lblSeatsLeft = new JLabel("Seats left:");
		lblSeatsLeft.setBounds(64, 300, 109, 20);
		getContentPane().add(lblSeatsLeft);
		
		txtSeatsAvailable = new JTextField();
		txtSeatsAvailable.setEditable(false);
		txtSeatsAvailable.setText(Integer.toString(seatsAvailable));
		txtSeatsAvailable.setBounds(209, 261, 146, 26);
		getContentPane().add(txtSeatsAvailable);
		txtSeatsAvailable.setColumns(10);
		
		txtSeatsUsed = new JTextField();
		txtSeatsUsed.setEditable(false);
		txtSeatsUsed.setBounds(209, 297, 146, 26);
		txtSeatsUsed.setText(Integer.toString(seatsLeft));
		getContentPane().add(txtSeatsUsed);
		txtSeatsUsed.setColumns(10);
		
		JLabel lblGuides = new JLabel("Guides:");
		lblGuides.setBounds(370, 264, 69, 20);
		getContentPane().add(lblGuides);
		
		txtGuides = new JTextField();
		txtGuides.setEditable(false);
		txtGuides.setText(guides);
		txtGuides.setBounds(493, 261, 146, 26);
		getContentPane().add(txtGuides);
		txtGuides.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(370, 303, 69, 20);
		getContentPane().add(lblDuration);
		
		txtDuration = new JTextField();
		txtDuration.setText(duration);
		txtDuration.setEditable(false);
		txtDuration.setBounds(493, 297, 146, 26);
		getContentPane().add(txtDuration);
		txtDuration.setColumns(10);
		
		JLabel lblReviews = new JLabel("Reviews:");
		lblReviews.setBounds(64, 468, 69, 20);
		getContentPane().add(lblReviews);
		
		JButton btnEvaluate = new JButton("Evaluate");
		btnEvaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SNoGuests = txtNoGuests.getText();
				int noGuests = Integer.valueOf(SNoGuests);
				totalPrice = price*noGuests;
				txtProduct.setText(Integer.toString(totalPrice));
				evaluate(seatsLeft,noGuests);
			}
		});
		btnEvaluate.setBounds(428, 376, 211, 29);
		getContentPane().add(btnEvaluate);
		
		JTextArea txtReviews = new JTextArea();
		txtReviews.setEditable(false);
		txtReviews.setBounds(209, 468, 430, 100);
		getContentPane().add(txtReviews);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		
		JLabel lblPlaceOfArrival = new JLabel("Place of arrival:");
		lblPlaceOfArrival.setBounds(370, 336, 113, 20);
		getContentPane().add(lblPlaceOfArrival);
		
		txtPlaceOfArrival = new JTextField();
		txtPlaceOfArrival.setEditable(false);
		txtPlaceOfArrival.setText(placeOfArrival);
		txtPlaceOfArrival.setBounds(493, 333, 146, 26);
		getContentPane().add(txtPlaceOfArrival);
		txtPlaceOfArrival.setColumns(10);
		
		// Buttons and frame end
	}
	
	private void evaluate(int seatsLeft, int NoGuests ){
		if(seatsLeft < NoGuests){
			JOptionPane.showMessageDialog(null, "Not enough seats available");
		}
		else{
			JOptionPane.showMessageDialog(null, "There are enough seats for your party");
		}
	}
	
	public static String minuteToTime(int minute) {
        int hour = minute / 60;
        minute %= 60;
        if(minute == 0) return (hour + " hours");
        else return (hour + " hours and " + minute + " minutes");
    }
	
	public static String seperateGuides(ArrayList<String> guides){
		String guidesUsed = guides.get(0);
		for(int i = 1;i<guides.size();i++){
			guidesUsed += ", " + guides.get(i);
		}
		return guidesUsed;
	}
}
