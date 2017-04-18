package storage;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Booking;
import model.BookingSearchCriteria;

public class BookingDatabaseController {

	private String DB_URL;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;


	private void connect() throws ClassNotFoundException, SQLException
	{
		File resourcesDirectory = new File("src/resources");
		DB_URL = "jdbc:sqlite:" + resourcesDirectory.getAbsolutePath() + "\\TripDatabase.db";
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection(DB_URL);
	}

	
	private void getUserBookingsGSS(BookingSearchCriteria criteria) throws SQLException
	{ 
		//Name. Padded with % so I can deal with the empty string and some valid criteria in one line.
		stmt.setInt(1,criteria.getBookingId());
	}
	
	

public boolean cancelBooking(int bookingId) throws SQLException
	{
		boolean IsItInWorkingOrder = false;
		try {
			String sql;
			connect();
			// get the trip id of the trip to be canceled		
			sql = "SELECT TripId FROM Bookings WHERE bookingId == " + bookingId;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int TripId = rs.getInt("TripId");
			
			
			// find the number of seats at the moment currently available the trip booked
			sql = "SELECT seatsLeft FROM Trips WHERE tripId == " + TripId;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int CurrentNumSeaats = rs.getInt("seatsLeft");
						
			// find the number of seats in the booking that is to be canseled 
			sql = "SELECT NumberOfSeats FROM Bookings WHERE bookingId == " + bookingId;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int numberOfSeatsBooked = rs.getInt("NumberOfSeats");
						
			int UpdatednumberOfSeats = CurrentNumSeaats + numberOfSeatsBooked;
			//Add the seats from the canseled booking to the seats left.
			sql = "UPDATE Trips SET seatsLeft = " + UpdatednumberOfSeats + " WHERE tripId = " + TripId; 
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			
			
			sql = "DELETE FROM Bookings "
					+ " WHERE BookingId == " + bookingId;
		
			stmt = conn.prepareStatement(sql);
			int numberOfLinesAffected = stmt.executeUpdate();
			if(numberOfLinesAffected > 0){
				IsItInWorkingOrder = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}

		finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		return IsItInWorkingOrder;
	}
public void setUserBookings(Booking booking) throws SQLException 
	{				
		/*
		 * CREATE TABLE "Bookings" ("BookingId" INTEGER PRIMARY KEY  NOT NULL , "TripId" INTEGER NOT NULL , 
		 * "NumberOfSeats" INTEGER NOT NULL , "NameOfBuyer" TEXT NOT NULL , "PhoneOfBuyer" INTEGER NOT NULL , 
		 * "EmailOfBuyer" TEXT NOT NULL )
		 */

		try {

			String sql = "SELECT MAX(bookingID) AS bookingId FROM Bookings";
			connect();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int highestBookingId = rs.getInt("bookingId");

			sql = "INSERT INTO Bookings"
					+ " VALUES (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,highestBookingId+1);
			stmt.setInt(2,booking.getTripId());
			stmt.setInt(3, booking.getNumberOfGuests());
			stmt.setString(4,booking.getNameOfBuyer());
			stmt.setInt(5, booking.getPhoneOfBuyer());
			stmt.setString(6, booking.getEmailOfBuyer());
			stmt.executeUpdate();
			
			// feching the trip ID to find tripId in Trips table
			highestBookingId = highestBookingId + 1;
			sql = "SELECT TripId FROM Bookings WHERE bookingId == " + highestBookingId;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int TripId = rs.getInt("TripId");
			
			// find the number of seats already avaliable in a trip 
			sql = "SELECT seatsLeft FROM Trips WHERE tripId == " + TripId;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int CurrentNumSeaats = rs.getInt("seatsLeft");
			
			// find the number of seat bookings in the booking
			sql = "SELECT NumberOfSeats FROM Bookings WHERE bookingId == " + highestBookingId;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int numberOfSeatsBooked = rs.getInt("NumberOfSeats");
			
			int UpdatednumberOfSeats = CurrentNumSeaats - numberOfSeatsBooked;
			//and deduct that from that the number of seats booked.
			sql = "UPDATE Trips SET seatsLeft = " + UpdatednumberOfSeats + " WHERE tripId = " + TripId; 
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}

		finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}

	}
	

public ArrayList<Booking> getUserBookingsCriteria(BookingSearchCriteria criteria) throws SQLException{

		String getUserBookingsSQL = 	
				"SELECT * FROM Bookings "
						+ "WHERE BookingId == ? ;";

		ArrayList<Booking> Bookings = new ArrayList<Booking>(); // Will return this in the end.
		stmt = null;
		try{
			connect();
			stmt = conn.prepareStatement(getUserBookingsSQL);
			getUserBookingsGSS(criteria); //Stops sql injections!
			rs = stmt.executeQuery(); // Send in completed secure SQL query.
			// Extract data from result set
			// We pass rs.get methods with name of column in the database. Lots of lines, but makes it easier to modify later.
			while(rs.next())
			{
				int Tid = rs.getInt("TripId");
				int NumSeats = rs.getInt("NumberOfSeats");
				String name = rs.getString("NameOfBuyer");
				int Phone= rs.getInt("PhoneOfBuyer");
				String Email = rs.getString("EmailOfBuyer");

				Booking bookings = new Booking(Tid,NumSeats,name,Phone,Email);
				Bookings.add(bookings);
			}

		}
		//Handle errors for JDBC
		catch(SQLException se) {se.printStackTrace();}
		//Handle errors for Class.forName
		catch(Exception e){e.printStackTrace();}
		finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		return Bookings;
	}
	

	public boolean seatsAvailableOK(int tripid, int seatsordered) throws SQLException{
		boolean awnswer = false;
		stmt = null;
		try{
			String sql = "SELECT seatsLeft FROM Trips WHERE tripId == " + tripid ;
			connect();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); // Send in completed secure SQL query.
			int TripSeatsleft = rs.getInt("seatsLeft");
			
			int seats = TripSeatsleft - seatsordered;
			if(seats >= 0){
				awnswer = true;
			}else{
				awnswer = false;
			}
			
		}
		//Handle errors for JDBC
		catch(SQLException se) {se.printStackTrace();}
		//Handle errors for Class.forName
		catch(Exception e){e.printStackTrace();}
		finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		return awnswer;
	}
public boolean bookingWithBookingIDExists(int bookingID) throws SQLException{
	
	boolean awnswer = false;
	try{
	connect();
	String sql = "SELECT bookingId FROM bookings WHERE bookingId == " + bookingID ;
	stmt = conn.prepareStatement(sql);
	rs = stmt.executeQuery();
	
	if(rs.next()){
		awnswer= true; //yes exist
		}

	}catch(SQLException se) {se.printStackTrace();}
	//Handle errors for Class.forName
	catch(Exception e){e.printStackTrace();}
	finally{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	return awnswer;
	
	}
	
	public static void main(String[] args) 
	{
		BookingDatabaseController tdbd = new BookingDatabaseController();
//		Booking tsc = new Booking(2,3,"lala",334455,"nana");
		Booking tsc = new Booking(2,3,"lala",334455,"nana");

		//ArrayList<Booking> booked = tdbd.getUserBookingsCriteria(tsc);
		//for (Booking booking : booked) System.out.println(booking);
//		try {
//			tdbd.setUserBookings(tsc);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//try{
//	tdbd.cancelUserBooking(tsc);
//}catch(SQLException e){
//	e.printStackTrace();
//}
		


	}
}
