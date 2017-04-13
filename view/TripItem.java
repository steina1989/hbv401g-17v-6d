package view;

import java.awt.Component;

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

public class TripItem extends JPanel {
	
	
	Color defaultColor;
	
	public TripItem(Trip trip) {
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
		
		JLabel lblNewLabel = new JLabel("Le name of Triiiiiiiiiiiiip");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, this);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblNewLabel);
		
		JLabel LabelPicture = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 16, SpringLayout.EAST, LabelPicture);
		springLayout.putConstraint(SpringLayout.NORTH, LabelPicture, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, LabelPicture, 10, SpringLayout.WEST, this);
		LabelPicture.setIcon(new ImageIcon(TripItem.class.getResource("/resources/categories/skiing.png")));
		add(LabelPicture);
		
		JLabel lblShortTripDescription = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblShortTripDescription, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblShortTripDescription, -10, SpringLayout.EAST, lblNewLabel);
		lblShortTripDescription.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblShortTripDescription);
		
		JButton btnSeeMore = new JButton("See more");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSeeMore, 0, SpringLayout.SOUTH, LabelPicture);
		springLayout.putConstraint(SpringLayout.EAST, btnSeeMore, -10, SpringLayout.EAST, this);
		add(btnSeeMore);
		
		JLabel lblNewLabel_1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_1.setIcon(new ImageIcon(TripItem.class.getResource("/resources/stars/3star.png")));
		add(lblNewLabel_1);
		
		JLabel lblXReviews = new JLabel("x reviews!");
		springLayout.putConstraint(SpringLayout.WEST, lblXReviews, 6, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblXReviews, 0, SpringLayout.SOUTH, lblNewLabel_1);
		add(lblXReviews);
		
		JTextPane txtpnFirstXCharacters = new JTextPane();
		txtpnFirstXCharacters.setForeground(Color.GRAY);
		txtpnFirstXCharacters.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtpnFirstXCharacters.setEditable(false);
		txtpnFirstXCharacters.setOpaque(false);
		txtpnFirstXCharacters.setText("First x characters of trip description following a few dots in seducing gray.......");
		springLayout.putConstraint(SpringLayout.NORTH, txtpnFirstXCharacters, 6, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, txtpnFirstXCharacters, 16, SpringLayout.EAST, LabelPicture);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnFirstXCharacters, 51, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, txtpnFirstXCharacters, 336, SpringLayout.EAST, LabelPicture);
		add(txtpnFirstXCharacters);
	}
}
