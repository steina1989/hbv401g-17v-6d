package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import view.MainFrame;;

public class CancelBookingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private BookingController bookingController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBookingFrame frame = new CancelBookingFrame();
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
	public CancelBookingFrame(BookingController bookingController) {

		this.bookingController = bookingController;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertYourBooking = new JLabel("Insert your booking ID:");
		lblInsertYourBooking.setBounds(10, 39, 112, 14);
		contentPane.add(lblInsertYourBooking);
		
		textField = new JTextField();
		textField.setBounds(142, 36, 181, 20);
		contentPane.add(textField);
		textField.setColumns(50);
		textField.setMaximumSize( textField.getPreferredSize() );
		
		JButton btnCancelBooking = new JButton("Cancel booking");
		btnCancelBooking.setBounds(114, 120, 105, 23);
		contentPane.add(btnCancelBooking);
		
		JLabel lblConfirmationText = new JLabel("New label");
		lblConfirmationText.setBounds(142, 81, 46, 14);
		contentPane.add(lblConfirmationText);
	}
}
