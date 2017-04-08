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

	private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");
	
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
	 */

	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) throws SQLException{

		ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
		stmt = null;
		try{
			connect();
			stmt = conn.createStatement();
			String sqlinput = "SELECT * FROM Trips NATURAL JOIN Guides;"; // To be replaced by generateSQL(criteria)
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
				Date dateOfDeparture = df.parse(rs.getString("dateOfDeparture"));
				Date dateOfReturn = df.parse(rs.getString("dateOfReturn"));
			
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
	private String generateSQL(TripSearchCriteria criteria)
	{
		return null;
	}


	// Just for testing
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		TripDatabaseController tdbd = new TripDatabaseController();

		ArrayList<Trip> trips = tdbd.getTripsByCriteria(null);
		for (Trip trip : trips)
		{
			System.out.println(trip);
		}
		Guide gd = trips.get(0).getGuide();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//application will be closed when you close frame
		frame.setSize(800,600);
		frame.setLocation(200,200);
		JLabel label = new JLabel();
		frame.getContentPane().add(label);
		try {
			gd.getImage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
    label.setIcon(new ImageIcon(gd.getImg()));
    
	}

}	//end
