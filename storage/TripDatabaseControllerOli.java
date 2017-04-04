package storage;
import java.io.File;
import java.sql.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Trip;
import model.TripSearchCriteria;


public class TripDatabaseControllerOli {

	static String DB_URL;
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;

	/*
	 * Connects to database. 
	 */
	private static void connect() throws ClassNotFoundException, SQLException
	{
		File resourcesDirectory = new File("src/storage");
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
	public static ArrayList<Trip> getTripsByParameter(TripSearchCriteria criteria) throws SQLException{

		ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
		stmt = null;
		try{
			connect();
			stmt = conn.createStatement();
			String sqlinput = "SELECT * FROM Trips;"; // To be replaced by generateSQL(criteria)
			rs = stmt.executeQuery(sqlinput); // Send in completed SQL query.

			// Extract data from result set
			// We pass rs.get methods with name of column in the database. Lots of lines, but easy to modify later.
			while(rs.next())
			{
				Trip trip = new Trip();
				trip.setId(rs.getInt("tripId"));
				trip.setName(rs.getString("tripName"));
				trip.setCategory(rs.getString("tripCategory"));
				trip.setSeatsAvailable(rs.getInt("tripSeatsAvailable"));
				trip.setDescription(rs.getString("tripDescription"));
				trip.setPrice(rs.getInt("tripPrice"));
				

				System.out.println(trip);
				
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
		connect();	
		getTripsByParameter(null);
	}

}	//end
