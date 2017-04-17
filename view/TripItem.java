package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import controller.BookingController;
import controller.TripController;
import model.Trip;

/*
 * This class is a Trip visualizer module based on JPanel. Each instance of this class will be a "list"-item in the ListOfTripsPanel.
 * To do :
 * Add event listener on "See more" to load a new TripInfoFrame.
 * Maybe add some more details like DateOfDeparture.
 * 
 */

public class TripItem extends JPanel {
	
	TripController tripController;
	BookingController bookingController;
	
	Color defaultColor;
	Dimension preferredSize = new Dimension(560,100);
	
	public TripItem(final Trip trip, final TripController tripController, BookingController bookingController) {
		this.tripController = tripController;
		this.bookingController = bookingController;
		
		setBorder(null);
		setPreferredSize(preferredSize); 
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				defaultColor = ((Component) e.getSource()).getBackground();
				((Component) e.getSource()).setBackground(Color.LIGHT_GRAY);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
					((Component) e.getSource()).setBackground(defaultColor);
			}
		});
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel nameLabel = new JLabel(trip.getName());
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, this);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(nameLabel);
		
		JLabel categoryPicture = new JLabel("");
		categoryPicture.setToolTipText("Icon designed by Madebyoliver from Flaticon");
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 16, SpringLayout.EAST, categoryPicture);
		springLayout.putConstraint(SpringLayout.NORTH, categoryPicture, 0, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, categoryPicture, 10, SpringLayout.WEST, this);
		categoryPicture.setPreferredSize(new Dimension(50,50));
		String resource = "/resources/categories/"+trip.getCategory().toLowerCase()+".png";
		categoryPicture.setIcon(new ImageIcon(TripItem.class.getResource(resource)));
		add(categoryPicture);
		
		JLabel lblShortTripDescription = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblShortTripDescription, 52, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblShortTripDescription, 215, SpringLayout.EAST, categoryPicture);
		lblShortTripDescription.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblShortTripDescription);
		
		JButton btnSeeMore = new JButton("See more");
		btnSeeMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tripController.tripSeeMoreClicked(trip);
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnSeeMore, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSeeMore, -10, SpringLayout.EAST, this);
		add(btnSeeMore);
		
		JLabel starsLabel = new JLabel("");
		starsLabel.setPreferredSize(new Dimension(105,20));
		springLayout.putConstraint(SpringLayout.NORTH, starsLabel, 0, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, starsLabel, 6, SpringLayout.EAST, nameLabel);
		starsLabel.setIcon(new ImageIcon(TripItem.class.getResource("/resources/stars/"+Integer.toString(trip.getMeanRating())+"star.png")));
		add(starsLabel);
		
		String numberOfReviewsText;
		int noReviews = trip.getNoReviews();
		if (noReviews == 0 ) numberOfReviewsText = "No reviews yet.";
		else numberOfReviewsText = Integer.toString(trip.getNoReviews())+" reviews!";
		JLabel countReviewsLabel = new JLabel(numberOfReviewsText);
		springLayout.putConstraint(SpringLayout.NORTH, countReviewsLabel, 8, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, countReviewsLabel, 6, SpringLayout.EAST, starsLabel);
		add(countReviewsLabel);
		
		JLabel excerptFromDescription = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, excerptFromDescription, 0, SpringLayout.SOUTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, excerptFromDescription, 10, SpringLayout.WEST, nameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, excerptFromDescription, -20, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, excerptFromDescription, -6, SpringLayout.WEST, btnSeeMore);
		excerptFromDescription.setForeground(Color.GRAY);
		excerptFromDescription.setFont(new Font("Tahoma", Font.ITALIC, 11));
		excerptFromDescription.setOpaque(false);
		String excerpt = trip.getDescription().substring(0,200);
		excerptFromDescription.setText("<html>"+excerpt+"..."+"</html>");
		add(excerptFromDescription);
		
		JLabel categoryLabel = new JLabel(trip.getCategory());
		springLayout.putConstraint(SpringLayout.NORTH, categoryLabel, 6, SpringLayout.SOUTH, categoryPicture);
		springLayout.putConstraint(SpringLayout.WEST, categoryLabel, 0, SpringLayout.WEST, categoryPicture);
		categoryLabel.setFont(new Font("Arial", Font.BOLD, 11));
		add(categoryLabel);
		
		
		SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
		Integer price = trip.getPrice();
		String date = df.format(trip.getDateOfDeparture());
		JLabel lblDateAndPrice = new JLabel(date+"   Price:"+ String.format("%,d ISK",price));

		springLayout.putConstraint(SpringLayout.WEST, lblDateAndPrice, 0, SpringLayout.WEST, nameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDateAndPrice, 0, SpringLayout.SOUTH, this);
		add(lblDateAndPrice);
		

	}
	
	public Dimension getSize(){
		return this.getPreferredSize();
	}
}
