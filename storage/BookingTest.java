package storage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Guide;
import model.Review;
import model.Trip;
import model.TripSearchCriteria;// vantar að laga þetta fyrir booking

public class BookingTest {

	private String DB_URL;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private String getUserBookingsSQL = 	
			"SELECT * FROM Bokkings "
			+ "WHERE BookingId == ? ;";
	
	private String cancelBookingSQL = 	
			"DELETE FROM Bookings " + 
			"WHERE BookingId ==  ? ;";
					
    private String setUserBookingsSQL = 
    		"INSERT INTO Bookings(BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer) VALUES ( " 
				+ "? ," + "? ," + "? ," + "? ," + "? ," + "? ;";
		
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

private void cancelBookingGSS(TripSearchCriteria criteria) throws SQLException
{
	//Name. Padded with % so I can deal with the empty string and some valid criteria in one line.
	stmt.setInt(1,criteria.getBookingId());

}


private void setUserBookingsGSS(TripSearchCriteria criteria) throws SQLException
{			
	//Name. Padded with % so I can deal with the empty string and some valid criteria in one line.
	stmt.setInt(1,criteria.getBookingId());
	//Dates
	stmt.setInt(2, criteria.getTripId());
	stmt.setInt(3, criteria.getNumberOfSeats());;
	//Prices
	stmt.setString(4,"%" + criteria.getNameOfBuyer()+ "%" );
	stmt.setsetInt(5, criteria.getPhoneOfBuyer());
	//Category
	stmt.setString(6, "%" +criteria.getEmailOfBuyer()+ "%");

}
//----------------------->  Generate Secure SQL - End


public ArrayList<Trip> getUserBookingsCriteria(BookingSearchCriteria criteria) throws SQLException{

	String getUserBookingsSQL = 	
			"SELECT * FROM Bokkings "
			+ "WHERE BookingId == ? ;";
	
			ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
			stmt = null;
			try{
				connect();
				stmt = conn.prepareStatement(getUserBookingsSQL);
				generateSecureStatement(criteria); //Stops sql injections!
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
					
					Trip trip = new Trip(name,Tid,NumSeats,name,Phone,Email);
					listOfTrips.add(trip);
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
			return listOfTrips;
		}
public void setUserBookingsCriteria(UserBookingsCriteria criteria) throws SQLException{

	String setUserBookingsSQL = "INSERT INTO Bookings(BookingId,TripId,NumberOfSeats,NameOfBuyer,PhoneOfBuyer,EmailOfBuyer) VALUES ( " 
			+ "? ," + "? ," + "? ," + "? ," + "? ," + "? ;";
	
			ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
			stmt = null;
			try{
				connect();
				stmt = conn.prepareStatement(setUserBookingsSQL);
				generateSecureStatement(criteria); //Stops sql injections!
				rs = stmt.executeQuery(); // Send in completed secure SQL query.
				// Extract data from result set
				// We pass rs.get methods with name of column in the database. Lots of lines, but makes it easier to modify later.
				while(rs.next())
				{
					int Bid = rs.setInt("BookingId");
					int Tid = rs.setInt("tripId");
					int NumSeats = rs.setInt("NumberOfSeats");
					String name = rs.setString("NameOfBuyer");
					int Phone= rs.setInt("PhoneOfBuyer");
					String Email = rs.setString("EmailOfBuyer");
					
					Trip trip = new Trip(name,Tid,NumSeats,name,Phone,Email);
					listOfTrips.add(trip);
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
			
		}

public void cancelBookingCriteria(UserBookingsCriteria criteria) throws SQLException{

	String cancelBookingSQL = 	
			"DELETE FROM Bookings " + 
			"WHERE BookingId ==  ? ;";
	
			stmt = null;
			try{
				connect();
				stmt = conn.prepareStatement(getUserBookingsSQL);
				generateSecureStatement(criteria); //Stops sql injections!
				rs = stmt.executeQuery(); // Send in completed secure SQL query.
				// Extract data from result set
				// We pass rs.get methods with name of column in the database. Lots of lines, but makes it easier to modify later.
				while(rs.next())
				{
					int Bid = rs.getInt("BookingId");
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
		}

public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException
{
	BookingTest tdbd = new BookingTest();
	BookingSearchCriteria tsc = new BookingSearchCriteria();
	tsc.setBookingId(0);
	tsc.settripId(0);
	tsc.setNumberOfSeats(0);
	tsc.setNameOfBuyer("Road trip");
	tsc.setPhoneOfBuyer(0);
	tsc.setEmailOfBuyer("");

	ArrayList<Trip> trips = tdbd.getUserBookingsCriteria(tsc);
	

}
}
