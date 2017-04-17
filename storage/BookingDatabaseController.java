package storage;

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
		DB_URL = "jdbc:sqlite::resource:resources\\TripDatabase.db";
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection(DB_URL);
	}

	// ----------------------->  Generate Secure SQL - beginning
	private void getUserBookingsGSS(BookingSearchCriteria criteria) throws SQLException
	{ 
		//Name. Padded with % so I can deal with the empty string and some valid criteria in one line.
		stmt.setInt(1,criteria.getBookingId());
	}

	private void cancelBookingGSS(BookingSearchCriteria criteria) throws SQLException
	{
		//Name. Padded with % so I can deal with the empty string and some valid criteria in one line.
		stmt.setInt(1,criteria.getBookingId());
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
			System.out.println(highestBookingId);
			
			//BAADSD
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
			
			stmt = conn.prepareStatement("SELECT COUNT(*)AS Fjoldi FROM Bookings");
			rs = stmt.executeQuery();
			System.out.println(rs.getInt("Fjoldi"));
			

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
	//----------------------->  Generate Secure SQL - End


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
	//private  void setUserBookingsCriteria(BookingSearchCriteria criteria) throws SQLException{
	//
	//	String setUserBookingsSQL = "INSERT INTO Bookings(BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer) VALUES ( " 
	//			+ "?" + ",? " +",? " +",? " +",?"+ ",?"+ ");" ;
	//			stmt = null;
	//			try{
	//				connect();
	//				stmt = conn.prepareStatement(setUserBookingsSQL);
	//				setUserBookingsGSS(criteria); //Stops sql injections!
	//				rs = stmt.executeQuery(); // Send in completed secure SQL query.
	//			}
	//			//Handle errors for JDBC
	//			catch(SQLException se) {se.printStackTrace();}
	//			//Handle errors for Class.forName
	//			catch(Exception e){e.printStackTrace();}
	//			finally{
	//				if(rs != null) rs.close();
	//				if(stmt != null) stmt.close();
	//				if(conn != null) conn.close();
	//			}
	//		System.out.println();
	//			
	//		}

	public void cancelBookingCriteria(BookingSearchCriteria criteria) throws SQLException{

		String cancelBookingSQL = 	
				"DELETE FROM Bookings " + 
						"WHERE BookingId ==  ? ;";

		stmt = null;
		try{
			connect();
			stmt = conn.prepareStatement(cancelBookingSQL);
			cancelBookingGSS(criteria); //Stops sql injections!
			rs = stmt.executeQuery(); // Send in completed secure SQL query.
			// Extract data from result set
			// We pass rs.get methods with name of column in the database. Lots of lines, but makes it easier to modify later.

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
	}

	public static void main(String[] args) 
	{
		BookingDatabaseController tdbd = new BookingDatabaseController();
		Booking tsc = new Booking(2,3,"lala",334455,"nana");


		//ArrayList<Booking> booked = tdbd.getUserBookingsCriteria(tsc);
		//for (Booking booking : booked) System.out.println(booking);
		try {
			tdbd.setUserBookings(tsc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
