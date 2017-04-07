package storage;
import java.io.File;
import java.sql.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Review;
import model.Trip;
import model.TripSearchCriteria;


public class TripDatabaseController {

	private String DB_URL;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

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
	 * CREATE TABLE [Trips] 
	 * 1([tripId] Integer, 
	 * 2[tripName] Text, 
	 * 3[tripDate] Text, 
	 * 4[locationId] Integer, 
	 * 5[tripPrice] Integer, 
	 * 6[tripDescription] Text, 
	 * 7[tripSeatsAvailable] Integer, 
	 * 8[tripCategory] Text);
	 */

	public ArrayList<Trip> getTripsByCriteria(TripSearchCriteria criteria) throws SQLException{

		ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
		stmt = null;
		try{
			connect();
			stmt = conn.createStatement();
			String sqlinput = "SELECT * FROM Trips;"; // To be replaced by generateSQL(criteria)
			rs = stmt.executeQuery(sqlinput); // Send in completed SQL query.

			// Extract data from result set
			// We pass rs.get methods with name of column in the database. Lots of lines, but makes it easier to modify later.
			while(rs.next())
			{
				int id = rs.getInt("tripId");
				String name = rs.getString("tripName");
				String cat = rs.getString("tripCategory");
				int seats = rs.getInt("tripSeatsAvailable");
				String desc = rs.getString("tripDescription");
				int price = rs.getInt("tripPrice");
				
				listOfTrips.add(null);
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
	}

}	//end
