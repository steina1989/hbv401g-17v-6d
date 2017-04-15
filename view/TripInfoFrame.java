package view;
import java.awt.Dimension;
import java.awt.Font;
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
import model.Review;
import model.Trip;
import java.awt.Component;


public class TripInfoFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Review> reviews;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TripInfoFrame(Trip trip) {

		
		
		Dimension space = new Dimension(0,10); //Space between components for 
		Font sectionFont = new Font("Arial", Font.BOLD, 16);
		
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
		
		
		SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
		header.setBounds(10, 11, 530, 80);
		contentPane.add(header);
		
		JLabel lblPrice = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.SOUTH, lblPrice, 0, SpringLayout.SOUTH, categoryLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblPrice, -10, SpringLayout.EAST, header);
		lblPrice.setText("Price: " + Integer.toString(trip.getPrice())+" ISK");
		lblPrice.setFont(sectionFont);
		header.add(lblPrice);
		
		JLabel date2 = new JLabel("DateDep");
		springLayout.putConstraint(SpringLayout.NORTH, date2, 0, SpringLayout.NORTH, lblPrice);
		header.add(date2);
		
		JLabel date1 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.WEST, date2, 0, SpringLayout.WEST, date1);
		springLayout.putConstraint(SpringLayout.SOUTH, date1, 0, SpringLayout.SOUTH, categoryPicture);
		springLayout.putConstraint(SpringLayout.EAST, date1, 0, SpringLayout.EAST, nameLabel);
		header.add(date1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 102, 530, 174);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Full description");
		lblNewLabel.setFont(sectionFont);
		panel.add(lblNewLabel);
		panel.add(Box.createRigidArea(space));
		
		JLabel lblFullDescription = new JLabel("<html>"+trip.getDescription()+"</html>");
		panel.add(lblFullDescription);
		panel.add(Box.createRigidArea(space));
		
		JLabel lblNewLabel_2 = new JLabel("Reviews");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(sectionFont);
		
		//Uncomment when Reviews has been added in constructor.
//		JLabel lblText = new JLabel();
//		StringBuffer bufferedString = new StringBuffer();
//		for (Review review : reviews)
//		{
//			bufferedString.append(review.getText());
//			bufferedString.append("\n\n");
//		}
//		panel.add(lblText);
		
		Component rigidArea = Box.createRigidArea(new Dimension(0, 10));
		panel.add(rigidArea);
		
		JLabel lbl = new JLabel("Seats left");
		lbl.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(lbl);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(0, 10));
		panel.add(rigidArea_1);
		
		JLabel lblseatsLeft = new JLabel("New label");
		lblseatsLeft.setText(Integer.toString(trip.getSeatsLeft()));
		panel.add(lblseatsLeft);
		
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setBounds(100, 100, 566, 585);

	}
}
