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
	public static void getTripsByParameter(TripSearchCriteria criteria){

		ArrayList<Trip> listOfTrips = new ArrayList<Trip>(); // Will return this in the end.
		Statement stmt = null;
		try{
			connect();
			stmt = conn.createStatement();
			String sqlinput = "SELECT * FROM Trips;"; // To be replaced by generateSQL(criteria)
			ResultSet rs = stmt.executeQuery(sqlinput); // Send in completed SQL query.

			// Extract data from result set
			while(rs.next())
			{
				Trip trip = new Trip();
				trip.setId((int)rs.getObject(1));
				trip.setName((String)rs.getObject(2));
				//trip.setDate((Date)rs.getObject(2));
				System.out.println(trip);
			}

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();

			}
		//Handle errors for JDBC
		catch(SQLException se) {se.printStackTrace();}
		
		catch(Exception e){e.printStackTrace();}
			//Handle errors for Class.forName
			
		finally{}

	}

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
