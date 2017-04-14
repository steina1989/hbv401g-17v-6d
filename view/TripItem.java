package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.SpringLayout;

import model.Trip;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class TripItem extends JPanel {
	
	
	Color defaultColor;
	
	public TripItem(Trip trip) {
		setBorder(null);
		setPreferredSize(new Dimension(600, 100));
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
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 16, SpringLayout.EAST, categoryPicture);
		springLayout.putConstraint(SpringLayout.NORTH, categoryPicture, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, categoryPicture, 10, SpringLayout.WEST, this);
		categoryPicture.setIcon(new ImageIcon(TripItem.class.getResource("/resources/categories/hiking.png")));
		add(categoryPicture);
		
		JLabel lblShortTripDescription = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblShortTripDescription, 52, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblShortTripDescription, 215, SpringLayout.EAST, categoryPicture);
		lblShortTripDescription.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblShortTripDescription);
		
		JButton btnSeeMore = new JButton("See more");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSeeMore, 0, SpringLayout.SOUTH, categoryPicture);
		springLayout.putConstraint(SpringLayout.EAST, btnSeeMore, -10, SpringLayout.EAST, this);
		add(btnSeeMore);
		
		JLabel starsLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, starsLabel, 0, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, starsLabel, 6, SpringLayout.EAST, nameLabel);
		starsLabel.setIcon(new ImageIcon(TripItem.class.getResource("/resources/stars/3star.png")));
		add(starsLabel);
		
		JLabel countReviewsLabel = new JLabel("x reviews!");
		springLayout.putConstraint(SpringLayout.NORTH, countReviewsLabel, 8, SpringLayout.NORTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, countReviewsLabel, 6, SpringLayout.EAST, starsLabel);
		add(countReviewsLabel);
		
		JTextPane excerptFromDescription = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, excerptFromDescription, 0, SpringLayout.SOUTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, excerptFromDescription, 10, SpringLayout.WEST, nameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, excerptFromDescription, -10, SpringLayout.SOUTH, categoryPicture);
		springLayout.putConstraint(SpringLayout.EAST, excerptFromDescription, 0, SpringLayout.EAST, countReviewsLabel);
		excerptFromDescription.setForeground(Color.GRAY);
		excerptFromDescription.setFont(new Font("Tahoma", Font.ITALIC, 11));
		excerptFromDescription.setEditable(false);
		excerptFromDescription.setOpaque(false);
		excerptFromDescription.setText("First x characters of trip description following a few dots in seducing gray.......");
		add(excerptFromDescription);
	}




}
