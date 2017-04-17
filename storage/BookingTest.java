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

public class BookingTest {

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
private void setUserBookingsGSS(BookingSearchCriteria criteria) throws SQLException
{			
	//Name. Padded with % so I can deal with the empty string and some valid criteria in one line.
	stmt.setInt(1,criteria.getBookingId());
	//Dates
	stmt.setInt(2, criteria.getTrip());
	stmt.setInt(3, criteria.getNumberOfGuests());;
	//Pricesn
	stmt.setString(4,"%" + criteria.getNameOfBuyer()+ "%" );
	stmt.setInt(5, criteria.getPhoneOfBuyer());
	//Category
	stmt.setString(6, "%" +criteria.getEmailOfBuyer()+ "%");
}
//----------------------->  Generate Secure SQL - End


public ArrayList<Booking> getUserBookingsCriteria(BookingSearchCriteria criteria) throws SQLException{

	String getUserBookingsSQL = 	
			"SELECT * FROM Bokkings "
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
					int Bid = rs.getInt("BookingId");
					int Tid = rs.getInt("tripId");
					int NumSeats = rs.getInt("NumberOfSeats");
					String name = rs.getString("NameOfBuyer");
					int Phone= rs.getInt("PhoneOfBuyer");
					String Email = rs.getString("EmailOfBuyer");
					
					Booking bookings = new Booking(Bid,Tid,NumSeats,name,Phone,Email);
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
public  void setUserBookingsCriteria(BookingSearchCriteria criteria) throws SQLException{

	String setUserBookingsSQL = "INSERT INTO Bookings(BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer) VALUES ( " 
			+ "? ," + "? ," + "? ," + "? ," + "? ," + "?" ;
			stmt = null;
			try{
				connect();
				stmt = conn.prepareStatement(setUserBookingsSQL);
				setUserBookingsGSS(criteria); //Stops sql injections!
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
		System.out.println();
			
		}

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

public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException
{
	BookingTest tdbd = new BookingTest();
	BookingSearchCriteria tsc = new BookingSearchCriteria();
	tsc.setBookingId(1);
	tsc.setTrip(3);
	tsc.setNumberOfGuests(2);
	tsc.setNameOfBuyer("Nonni");
	tsc.setPhoneOfBuyer(8676259);
	tsc.setEmailOfBuyer("Nonni@nonni.is"); 

	//ArrayList<Booking> booked = tdbd.getUserBookingsCriteria(tsc);
	//for (Booking bookings : booked) System.out.println(bookings);
	
	tdbd.setUserBookingsCriteria(tsc);

}
}
