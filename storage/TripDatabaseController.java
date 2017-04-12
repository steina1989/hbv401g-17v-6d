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

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Guide;
import model.Review;
import model.Trip;
import model.TripSearchCriteria;


public class TripDatabaseController {

	private String DB_URL;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss a");
	
	/*
	 * Connects to database. 
	 */
	private void connect() throws ClassNotFoundException, SQLException
	{
		File resourcesDirectory = new File("src/resources");
		DB_URL = "jdbc:sqlite:" + resourcesDirectory.getAbsolutePath() + "\\TripDatabase.db";
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection(DB_URL);
	}

	/*
	 * The schema for our database is (at the moment):
	 * [Trips] ([tripId] Integer, [tripName] Text, [dateOfDeparture] Text, [dateOfReturn] Text, [tripPrice] Integer,
	 * [tripDescription] Text, [seatsAvailable] Integer, [seatsLeft] Integer, [tripCategory] Text, [guideId] Integer);
	 *  
	 * [Guides] ([guideId] Integer, [guideName] Text, [guideDescription] Text, [guideProfileURL] Text);
	 * [Reviews] ([tripName] Text, [reviewText] Text, [stars] Integer);
	 * 
	 * It contains 20 trips with departure ranging from 19 april 2017 - 6 july 2017. (1492645755-1499378496) seconds from epoch.
	 */

	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) throws SQLException{

		ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
		stmt = null;
		try{
			connect();
			stmt = conn.createStatement();
			String sqlinput = generateSQL(criteria); // To be replaced by generateSQL(criteria)
			rs = stmt.executeQuery(sqlinput); // Send in completed SQL query.

			// Extract data from result set
			// We pass rs.get methods with name of column in the database. Lots of lines, but makes it easier to modify later.
			while(rs.next())
			{
				int id = rs.getInt("tripId");
				String name = rs.getString("tripName");
				String cat = rs.getString("tripCategory");
				int seatsleft = rs.getInt("SeatsAvailable");
				int seatsav = rs.getInt("seatsAvailable");
				String desc = rs.getString("tripDescription");
				int price = rs.getInt("tripPrice");
				Date dateOfDeparture = new Date(rs.getLong("dateOfDeparture")*1000);

				Date dateOfReturn = new Date(rs.getLong("dateOfReturn")*1000);
			  
				//Get guide information. ID is only used to Join tables.
				String guideName = rs.getString("guideName");
				String guideDescr = rs.getString("guideDescription");
				URL guideProfileUrl = new URL(rs.getString("guideProfileURL"));

				//Create Guide and Trip
				Guide guide = new Guide(guideName,guideDescr,guideProfileUrl);
				Trip trip = new Trip(name,id,dateOfDeparture,dateOfReturn,price,desc,seatsav,seatsleft,cat,guide);
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


	public ArrayList<Review> getTripReviews(String name) {
		// this needs to be implemented!
		return new ArrayList<Review>();
	}


	/*
	 * Needed to translate TripSearchCriteria into sql code for the getTripsByParameter function.
	 */
	public String generateSQL(TripSearchCriteria criteria)
	{
		//Assuming that DateLow is never empty or null
		String sql = 	"SELECT * FROM Trips NATURAL JOIN Guides WHERE dateOfDeparture BETWEEN "
				+ criteria.getDateLow().getTime()/1000
				+ " AND "
				+ criteria.getDateHigh().getTime()/1000;
		
		sql +=";";
		System.out.println("Output from generateSQL() = " + sql);
		
		return sql;
	}


	// Just for testing
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException
	{
		TripDatabaseController tdbd = new TripDatabaseController();
		TripSearchCriteria tsc = new TripSearchCriteria();
		tsc.setDateLow(new Date(1492645755000L));
		tsc.setDateHigh(new Date(Long.MAX_VALUE));
		
		ArrayList<Trip> trips = tdbd.getTripsByCriteria(tsc);

		for (Trip trip : trips)
		{
			System.out.print(trip+" ");
			System.out.println(trip.getDateOfDeparture().toString());
		}

	}

}	//end
