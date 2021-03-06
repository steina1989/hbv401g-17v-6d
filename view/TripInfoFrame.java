package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.BookingController;
import controller.TripController;
import model.Guide;
import model.Review;
import model.Trip;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class TripInfoFrame extends JFrame {

	private final BookingController bookingController;
	private final Trip trip;
	private JPanel contentPane;
	private ArrayList<Review> reviews;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.g
	 */
	public TripInfoFrame(final Trip trip, ArrayList<Review> reviews, final BookingController bookingController) {
		this.bookingController = bookingController;
		this.trip = trip;


		SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
		Dimension space = new Dimension(0,5); //Space between components for 
		Font sectionFont = new Font("Arial", Font.BOLD, 16);
		Guide guide = trip.getGuide();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel header = new JPanel();
		SpringLayout springLayout = new SpringLayout();
		header.setLayout(springLayout);

		JLabel nameLabel = new JLabel(trip.getName());
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, this);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		header.add(nameLabel);

		JLabel categoryPicture = new JLabel("");
		categoryPicture.setToolTipText("Icon designed by Madebyoliver from Flaticon");
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 16, SpringLayout.EAST, categoryPicture);
		springLayout.putConstraint(SpringLayout.NORTH, categoryPicture, 0, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, categoryPicture, 10, SpringLayout.WEST, this);
		categoryPicture.setPreferredSize(new Dimension(50,50));
		String resource = "/resources/categories/"+trip.getCategory().toLowerCase()+".png";
		categoryPicture.setIcon(new ImageIcon(TripItem.class.getResource(resource)));
		header.add(categoryPicture);

		JLabel starsLabel = new JLabel("");
		starsLabel.setPreferredSize(new Dimension(105,20));
		springLayout.putConstraint(SpringLayout.NORTH, starsLabel, 0, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, starsLabel, 6, SpringLayout.EAST, nameLabel);
		starsLabel.setIcon(new ImageIcon(TripItem.class.getResource("/resources/stars/"+Integer.toString(trip.getMeanRating())+"star.png")));
		header.add(starsLabel);

		String numberOfReviewsText;
		int noReviews = trip.getNoReviews();
		if (noReviews == 0 ) numberOfReviewsText = "No reviews yet.";
		else numberOfReviewsText = Integer.toString(trip.getNoReviews())+" reviews!";
		JLabel countReviewsLabel = new JLabel(numberOfReviewsText);
		springLayout.putConstraint(SpringLayout.NORTH, countReviewsLabel, 8, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, countReviewsLabel, 6, SpringLayout.EAST, starsLabel);
		header.add(countReviewsLabel);


		JLabel categoryLabel = new JLabel(trip.getCategory());
		springLayout.putConstraint(SpringLayout.NORTH, categoryLabel, 6, SpringLayout.SOUTH, categoryPicture);
		springLayout.putConstraint(SpringLayout.WEST, categoryLabel, 0, SpringLayout.WEST, categoryPicture);
		categoryLabel.setFont(new Font("Arial", Font.BOLD, 11));
		header.add(categoryLabel);

		header.setBounds(10, 11, 530, 80);
		contentPane.add(header);

		JLabel lblPrice = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.SOUTH, lblPrice, 0, SpringLayout.SOUTH, categoryLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblPrice, -10, SpringLayout.EAST, header);
		lblPrice.setText("Price: " + String.format("%,d ISK", trip.getPrice()));
		lblPrice.setFont(sectionFont);
		header.add(lblPrice);

		JLabel date2 = new JLabel("Return: "+df.format(trip.getDateOfReturn()));
		springLayout.putConstraint(SpringLayout.NORTH, date2, 0, SpringLayout.NORTH, lblPrice);
		springLayout.putConstraint(SpringLayout.WEST, date2, 28, SpringLayout.EAST, categoryLabel);
		springLayout.putConstraint(SpringLayout.EAST, date2, 253, SpringLayout.EAST, categoryLabel);
		header.add(date2);

		JLabel date1 = new JLabel("Departure: "+df.format(trip.getDateOfDeparture()));
		springLayout.putConstraint(SpringLayout.WEST, date1, 0, SpringLayout.WEST, date2);
		springLayout.putConstraint(SpringLayout.SOUTH, date1, 0, SpringLayout.SOUTH, categoryPicture);
		springLayout.putConstraint(SpringLayout.EAST, date1, -21, SpringLayout.EAST, date2);
		header.add(date1);

		StringBuffer stringbuffer = new StringBuffer("<html>");
		for (Review review : reviews){
			stringbuffer.append("<b>"+review.getReviewHeader()+"</b><br>");
			stringbuffer.append(review.getReviewText()+"<br>");
		}
		stringbuffer.append("</html>");

		JPanel panel = new JPanel();
		panel.setBounds(10, 102, 530, 357);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblNewLabel = new JLabel("Full description");
		lblNewLabel.setFont(sectionFont);
		panel.add(lblNewLabel);
		panel.add(Box.createRigidArea(space));

		JLabel lblFullDescription = new JLabel();
		lblFullDescription.setText("<html>"+trip.getDescription()+"</html>");
		lblFullDescription.setFocusable(false);
		lblFullDescription.setOpaque(false);
		panel.add(lblFullDescription);
		panel.add(Box.createRigidArea(space));

		JLabel lbl = new JLabel("Seats left: "+trip.getSeatsLeft());
		lbl.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(lbl);
		panel.add(Box.createRigidArea(space));
		JLabel lblGuide = new JLabel("Your guide: " + guide.getName());
		lblGuide.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(lblGuide);
		panel.add(Box.createRigidArea(space));

		JLabel guideDesc = new JLabel(guide.getDescription());
		panel.add(guideDesc);
		panel.add(Box.createRigidArea(space));

		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(trip);
				System.out.println(bookingController);
				bookingController.addToCartClicked(trip);
				killThisWindow();
			}
		});
		panel.add(btnAddToCart);
		springLayout.putConstraint(SpringLayout.NORTH, btnAddToCart, -4, SpringLayout.NORTH, date2);
		springLayout.putConstraint(SpringLayout.EAST, btnAddToCart, -5, SpringLayout.WEST, lblPrice);
		Component rigidArea = Box.createRigidArea(space);
		panel.add(rigidArea);


		JLabel lblNewLabel_2 = new JLabel("Reviews");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(sectionFont);

		JLabel formattedReviews = new JLabel(stringbuffer.toString());
		panel.add(formattedReviews);




		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setBounds(100, 100, 562, 509);

	}
	
	public void killThisWindow() {
		this.setVisible(false);
		this.dispose();
	}
}
