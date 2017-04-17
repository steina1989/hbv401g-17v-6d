package storage;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import model.Booking;
import model.BookingSearchCriteria;
import model.Buyer;
import model.Trip;

public class BookingTest {

	private String DB_URL;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private void connect() throws ClassNotFoundException, SQLException
	{
		DB_URL = "jdbc:sqlite::resource:resources\\TripDatabase.db";
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection(DB_URL);
	}
	
	private void setUserBookings(Booking booking) throws SQLException
	{			
		
		/*
		 * CREATE TABLE "Bookings" ("BookingId" INTEGER PRIMARY KEY  NOT NULL , "TripId" INTEGER NOT NULL , 
		 * "NumberOfSeats" INTEGER NOT NULL , "NameOfBuyer" TEXT NOT NULL , "PhoneOfBuyer" INTEGER NOT NULL , 
		 * "EmailOfBuyer" TEXT NOT NULL )
		 */
		String sql = "SELECT MAX(bookingID) AS bookingId FROM Booking";
		rs = stmt.executeQuery(sql);
		int highestBookingId = rs.getInt("bookingId");
		
		sql = "INSERT INTO Bookings"
				+ "VALUES(highestBooking+1,?,?,?,?,?);";
		stmt.setInt(2,booking.getTripId());
		//Dates
		stmt.setInt(3, booking.getNumberOfGuests());
		stmt.setString(4,booking.getNameOfBuyer());
		stmt.setInt(5, booking.getPhoneOfBuyer());
		stmt.setString(6, booking.getEmailOfBuyer());
		stmt.executeQuery(sql);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException
	{
		BookingTest tdbd = new BookingTest();
		Booking tsc = new Booking();
		tsc.setTripId(3);
		tsc.setNumberOfGuests(2);
		tsc.setNameOfBuyer("Nonni");
		tsc.setPhoneOfBuyer(8676259);
		tsc.setEmailOfBuyer("Nonni@nonni.is"); 

		//ArrayList<Booking> booked = tdbd.getUserBookingsCriteria(tsc);
		//for (Booking booking : booked) System.out.println(booking);
		tdbd.setUserBookings(tsc);
		
		//tdbd.cancelBookingCriteria(tsc);

	}

}
