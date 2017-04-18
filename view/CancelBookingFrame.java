package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.BookingController;;

public class CancelBookingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private BookingController bookingController;
	private JLabel lblConfirmationText;


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
		
		lblConfirmationText = new JLabel("");
		lblConfirmationText.setBounds(61, 81, 202, 14);
		contentPane.add(lblConfirmationText);
		
		JButton btnCancelBooking = new JButton("Cancel booking");
		btnCancelBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					bookingController.cancelBookingFrameCancelBookingClicked(Integer.parseInt(textField.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancelBooking.setBounds(114, 120, 105, 23);
		contentPane.add(btnCancelBooking);
		

		}
	
	public void setConfirmationLabel(String message){
		lblConfirmationText.setText(message);
	}
}
