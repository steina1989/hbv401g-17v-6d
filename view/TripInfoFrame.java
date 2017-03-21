package view;
import model.Trip;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TripInfoFrame extends JFrame {

	private JPanel contentPane;
	private Trip trip;
	private int noGuests;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TripInfoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnAddtocart = new JButton("AddToCart");
		contentPane.add(btnAddtocart, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}
