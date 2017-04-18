package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.BookingController;

public class BookingInfoPanel extends JPanel {
	
	private final BookingController bookingController;
	
	private JTextField nameOfBuyerTextField;
	private JTextField emailOfBuyerTextField;
	private JTextField phoneOfBuyerTextField;
	private JTextField numberOfGuestsTextField;

	/**
	 * Create the panel.
	 */
	public BookingInfoPanel(final BookingController bookingController) {
		
		this.bookingController = bookingController;
		
		setLayout(null);
		
		JLabel lblNumberOfGuests = new JLabel("Number of guests:");
		lblNumberOfGuests.setBounds(10, 85, 103, 14);
		add(lblNumberOfGuests);
		
		JLabel lblNameOfBuyer = new JLabel("Name of buyer:");
		lblNameOfBuyer.setBounds(10, 11, 103, 14);
		add(lblNameOfBuyer);
		
		JLabel lblEmailOfBuyer = new JLabel("Email of buyer:");
		lblEmailOfBuyer.setBounds(10, 35, 103, 14);
		add(lblEmailOfBuyer);
		
		JLabel lblPhoneOfBuyer = new JLabel("Phone of buyer:");
		lblPhoneOfBuyer.setBounds(10, 60, 103, 14);
		add(lblPhoneOfBuyer);
		
		nameOfBuyerTextField = new JTextField();
		nameOfBuyerTextField.setBounds(123, 8, 299, 20);
		add(nameOfBuyerTextField);
		nameOfBuyerTextField.setColumns(10);
		
		emailOfBuyerTextField = new JTextField();
		emailOfBuyerTextField.setBounds(123, 32, 299, 20);
		add(emailOfBuyerTextField);
		emailOfBuyerTextField.setColumns(10);
		
		phoneOfBuyerTextField = new JTextField();
		phoneOfBuyerTextField.setBounds(123, 57, 152, 20);
		add(phoneOfBuyerTextField);
		phoneOfBuyerTextField.setColumns(10);
		
		numberOfGuestsTextField = new JTextField();
		numberOfGuestsTextField.setBounds(123, 82, 43, 20);
		add(numberOfGuestsTextField);
		numberOfGuestsTextField.setColumns(10);
	}

	public String getNameOfBuyer() {
		return nameOfBuyerTextField.getText();
	}

	public String getEmailOfBuyer() {
		return emailOfBuyerTextField.getText();
	}

	public int getPhoneOfBuyer() {
		return Integer.parseInt(phoneOfBuyerTextField.getText());
	}

	public int getNumberOfGuests() {
		return Integer.parseInt(numberOfGuestsTextField.getText());
	}
}
